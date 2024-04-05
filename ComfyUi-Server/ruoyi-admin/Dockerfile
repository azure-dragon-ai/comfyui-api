#指定基础镜像，在其上进行定制
#FROM reverie/armhf-alpine-oracle-jdk:latest
FROM openjdk:8u312-oraclelinux7

#维护者信息
MAINTAINER yangshare <717449318@qq.com>

ADD target/*.jar ruoyi-admin.jar

COPY src/main/resources/application.yml conf/application.yml

COPY src/main/resources/application-druid.yml conf/application-druid.yml

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "ruoyi-admin.jar","--spring.config.location=/conf/application.yml,/conf/application-druid.yml"]

# 设置时区
RUN /bin/cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && echo 'Asia/Shanghai' >/etc/timezone