
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
kubectl apply -f doc/StatefulSet.yml

``
