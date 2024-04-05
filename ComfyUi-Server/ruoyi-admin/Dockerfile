#指定基础镜像，在其上进行定制
#FROM reverie/armhf-alpine-oracle-jdk:latest
FROM openjdk:8u312-oraclelinux7

#维护者信息
MAINTAINER yangshare <717449318@qq.com>

ADD target/*.jar ruoyi-admin.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "ruoyi-admin.jar"]