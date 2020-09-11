FROM huahouye/java:heytea.20200225.oracle-jdk-8u212-alpine3.8

ENV JAVA_OPTS="-Duser.timezone=Asia/Shanghai -Xms256m -Xmx512m"
ENV PARAMS=""

COPY heytea-demo-spring-cloud-eureka-server-0.0.1-SNAPSHOT.jar /usr/local/heytea-demo-spring-cloud-eureka-server-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["sh","-c","java -jar $JAVA_OPTS /usr/local/heytea-demo-spring-cloud-eureka-server-0.0.1-SNAPSHOT.jar $PARAMS"]

EXPOSE 30001
