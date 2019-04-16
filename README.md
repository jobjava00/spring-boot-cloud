# spring-boot-cloud

## config-server

* <http://localhost:8888/microservice-a/default>

## service-consumer

* microservice-a 를 호출해서 값을 가져오는 서버(마이크로서비스의 기본 예제)

## microservice-a

* 부트스트랩에 컨피그 서버를 사용하기 위해 application.properties -> bootstrap.properties 로 변경
* <http://localhost:8080/message>
    * config-server 에 정의된 git repository 의 microservice-a 의 message 가져옴
* 8081포트에도 띄운다. <http://localhost:8081/message>
    * intellij VM Option 에 -Dserver.port=8081 설정해서 실행.
    * 기존 8080포트는 java -jar build/libs/microservice-a-0.0.1-SNAPSHOT.jar 로 실행 

## rabbitMQ 설치

* <https://t2t2tt.tistory.com/27>

## actuator 의존성 포함 시켜야 refresh URL 호출 가능

```groovy
implementation 'org.springframework.boot:spring-boot-starter-actuator'
```

## 설정 갱신

* 해당 서버만 갱신

```bash
curl -X POST http://localhost:8080/actuator/refresh
```

* 모든 서버 갱신
```bash
curl -X POST http://localhost:8080/actuator/bus-refresh
```