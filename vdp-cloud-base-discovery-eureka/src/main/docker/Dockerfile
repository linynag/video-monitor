#docker search jdk找到的最小jdk基础镜像
FROM airdock/oracle-jdk
VOLUME /tmp
ADD vdp-cloud-base-discovery-eureka-1.0.0-SNAPSHOT.jar /app.jar
EXPOSE 8761
EXPOSE 8762
EXPOSE 8763
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Duser.timezone=GMT+08","-jar","/app.jar"]

