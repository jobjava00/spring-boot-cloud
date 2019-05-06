# zipkin

```bash
compile("io.zipkin.java:zipkin-server:2.11.7") {
    exclude group: 'org.springframework.boot', module: 'spring-boot-starter-log4j2'
}
implementation 'io.zipkin.java:zipkin-autoconfigure-ui:2.11.7'

@EnableZipkinServer
@SpringBootApplication
public class ZipkinServerApplication {
```