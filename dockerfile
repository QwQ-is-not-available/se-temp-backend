FROM openjdk:17-ea-alpine
EXPOSE 8082

ADD sebackend*.jar /sebackend/sebackendapp.jar  
ENV TZ=Asia/Seoul

RUN apk add tzdata && cp /usr/share/zoneinfo/${TZ} /etc/localtime \
    && echo ${TZ} > /etc/timezone \
    && apk del tzdata

ENTRYPOINT ["java","-jar","/sebackend/sebackendapp.jar"]