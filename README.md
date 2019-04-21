# spring-boot-cloud

## config-server

* <http://localhost:8888/microservice-a/default>

## service-consumer

* microservice-a 를 호출해서 값을 가져오는 서버(마이크로서비스의 기본 예제)

### feign

* 페인은 최소한의 구성과 코드로, REST 서비스를 위한 REST 클라이언트 작성 가능

### ribbon

* client side 의 로드밸런서
* 전통적인 로드밸런서는 하드웨어가 필요하나 립본은 하드웨어 없이 소프트웨어로 로드밸런서 구현 가능

### eureka

* 서비스 검색을 위한 네임서버
    * eureka 등록이 필요한 client 에서 eureka-client Dependency 필요
        * implementation 'org.springframework.cloud:spring-cloud-starter-netflix-eureka-client'
* eureka 대시보드
    * <http://localhost:8761/>
* java11 에서 추가 필요

```groovy
compile 'com.sun.xml.bind:jaxb-core:2.3.0.1'
compile 'com.sun.xml.bind:jaxb-impl:2.3.1'
compile 'javax.xml.bind:jaxb-api:2.3.1'
```

## microservice-a

* 부트스트랩에 컨피그 서버를 사용하기 위해 application.properties -> bootstrap.properties 로 변경
* <http://localhost:8080/message>
    * config-server 에 정의된 git repository 의 microservice-a 의 message 가져옴
* 8081포트에도 띄운다. <http://localhost:8081/message>
    * intellij VM Option 에 -Dserver.port=8081 설정해서 실행.
    * 기존 8080포트는 java -jar build/libs/microservice-a-0.0.1-SNAPSHOT.jar 로 실행 

### rabbitMQ 설치

* <https://t2t2tt.tistory.com/27>

#### actuator 의존성 포함 시켜야 refresh URL 호출 가능

```groovy
implementation 'org.springframework.boot:spring-boot-starter-actuator'
```

#### 설정 갱신

* 해당 서버만 갱신

```bash
curl -X POST http://localhost:8080/actuator/refresh
```

* 모든 서버 갱신
```bash
curl -X POST http://localhost:8080/actuator/bus-refresh
```

### Zuul

* JVM 기반의 라우터이자 로드 밸런서
* 사용처
    * 인증과 보안
    * 모니터링과 분석
    * 동적 라우팅
    * 트래픽 조정
* eureka 등록

```bash
implementation 'org.springframework.cloud:spring-cloud-starter-netflix-eureka-client'

@EnableDiscoveryClient
public class ZuulApiGatewayServerApplication {
```

service-consumer 변경

```java
@FeignClient(name = "zuul-api-gateway")
@RibbonClient(name = "microservice-a")
public interface RandomServiceProxy {
	@GetMapping(value = "/microservice-a/random")
	List<Integer> getRandomNumbers();
}
```
