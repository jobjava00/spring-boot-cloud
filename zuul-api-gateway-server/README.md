# Zuul

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
## zipkin

```bash
spring.zipkin.base-url=http://localhost:9411/

implementation 'org.springframework.cloud:spring-cloud-starter-zipkin'
```