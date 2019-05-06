# eureka

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

## zipkin

```bash
spring.zipkin.base-url=http://localhost:9411/

implementation 'org.springframework.cloud:spring-cloud-starter-zipkin'
```