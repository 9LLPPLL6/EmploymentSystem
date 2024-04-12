# 使用基础的Java镜像
FROM openjdk:17-jdk-slim

# 设置工作目录
WORKDIR /app

# 将项目的JAR文件复制到镜像中
COPY server/target/myAPP.jar app.jar

# 设置环境变量
ENV MYSQL_HOST=localhost
ENV MYSQL_PORT=3306
ENV MYSQL_DATABASE=employment_system
ENV MYSQL_USERNAME=root
ENV MYSQL_PASSWORD=200296lpl
ENV REDIS_HOST=localhost
ENV REDIS_PORT=6379

# 暴露应用程序的端口
EXPOSE 15213

# 运行应用程序
CMD ["java", "-jar", "app.jar"]