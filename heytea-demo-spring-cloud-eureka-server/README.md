
## 1、本地开发

### 构建

```
mvn clean package
```

### 启动集群

目前 `application.yml` 配置文件预先配置了 3 个 peer 节点。

首先需要配置本地 /etc/hosts 追加以下配置

```
127.0.0.1 base-register-0.base-register.default.svc.cluster.local
127.0.0.1 base-register-1.base-register.default.svc.cluster.local
127.0.0.1 base-register-2.base-register.default.svc.cluster.local
```

可以依次使用 30001、30002、30003 三个端口来启动他们。

```
java -jar \
	target/heytea-demo-spring-cloud-eureka-server-0.0.1-SNAPSHOT.jar \
	--spring.profiles.active=develop \
	--server.port=30001 \
	--eureka.client.serviceUrl.defaultZone="http://base-register-0.base-register.default.svc.cluster.local:30001/eureka/, \
		http://base-register-1.base-register.default.svc.cluster.local:30002/eureka/, \
		http://base-register-2.base-register.default.svc.cluster.local:30003/eureka/"	

java -jar \
	target/heytea-demo-spring-cloud-eureka-server-0.0.1-SNAPSHOT.jar \
	--spring.profiles.active=develop \
	--server.port=30002 \
	--eureka.client.serviceUrl.defaultZone="http://base-register-0.base-register.default.svc.cluster.local:30001/eureka/, \
		http://base-register-1.base-register.default.svc.cluster.local:30002/eureka/, \
		http://base-register-2.base-register.default.svc.cluster.local:30003/eureka/"

java -jar \
	target/heytea-demo-spring-cloud-eureka-server-0.0.1-SNAPSHOT.jar \
	--spring.profiles.active=develop \
	--server.port=30003 \
	--eureka.client.serviceUrl.defaultZone="http://base-register-0.base-register.default.svc.cluster.local:30001/eureka/, \
		http://base-register-1.base-register.default.svc.cluster.local:30002/eureka/, \
		http://base-register-2.base-register.default.svc.cluster.local:30003/eureka/"

```

### 检查

浏览器打开 http://base-register-0.base-register.default.svc.cluster.local:30001/ 正常的话，会看到 3 个 “DS Replicas”

## 2、容器化和 K8S 部署

和本地开发有所不同，容器化和 K8S 部署，不会有端口冲突的问题。

```
构建工程
mvn clean package && \
rm -fr doc/heytea-demo-spring-cloud-eureka-server-0.0.1-SNAPSHOT.jar && \
mv target/heytea-demo-spring-cloud-eureka-server-0.0.1-SNAPSHOT.jar doc/

构建镜像
docker build -t base-register doc/

k8s 启动 STS
kubectl apply -f doc/StatefulSet.yml -n develop

```

## 3、极简部署

如果只是为了测试一下，执行下面的命令即可完成 k8s 部署。

```
cat > StatefulSet.yml << EOF
apiVersion: apps/v1
kind: StatefulSet
metadata:
  name: base-register
spec:
  serviceName: "base-register"
  selector:
    matchLabels:
      app: base-register
  replicas: 3
  template:
    metadata:
      labels:
        app: base-register
    spec:
      containers:
      - name: base-register
        image: huahouye/base-register
        env:
        - name: MANAGEMENT_SERVER_PORT
          value: "8081"
        - name: JAVA_OPTS
          value: -Duser.timezone=Asia/Shanghai -Xms256m -Xmx512m
        ports:
        - containerPort: 30001
        livenessProbe:
          failureThreshold: 3
          httpGet:
            path: /actuator/health
            port: 8081
            scheme: HTTP
          initialDelaySeconds: 30
          periodSeconds: 10
          timeoutSeconds: 5
          successThreshold: 1
        readinessProbe:
          failureThreshold: 3
          httpGet:
            path: /actuator/health
            port: 8081
            scheme: HTTP
          initialDelaySeconds: 30
          periodSeconds: 10
          timeoutSeconds: 5
          successThreshold: 1
        resources:
          requests:
            cpu: "0.5"
            memory: 512Mi
          limits:
            cpu: "1"
            memory: 800Mi
#      imagePullSecrets:
#      - name: registrypullsecret
      
---
apiVersion: v1
kind: Service
metadata:
  name: base-register
spec:
  type: NodePort
  ports:
  - port: 30001
    targetPort: 30001
    nodePort: 30001
  selector:
    app: base-register
EOF

kubectl apply -f StatefulSet.yml -n develop

```


