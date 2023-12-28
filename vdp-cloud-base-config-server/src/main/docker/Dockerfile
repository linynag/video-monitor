#docker search jdk找到的最小jdk基础镜像
FROM airdock/oracle-jdk
VOLUME /tmp
ADD vdp-cloud-base-config-server-1.0.0-SNAPSHOT.jar /app.jar
EXPOSE 20001
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Duser.timezone=GMT+08","-jar","/app.jar"]

