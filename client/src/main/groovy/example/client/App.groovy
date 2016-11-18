package example.client

import groovy.util.logging.Slf4j
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.netflix.feign.EnableFeignClients

import javax.inject.Inject

@Slf4j
@EnableFeignClients
@SpringBootApplication
class App {
    @Inject
    HelloService helloService

    void run(String... args) {
        def hello = helloService.hello(args)
        log.info("$hello")
    }

    static void main(String[] args) {
        def applicationContext = SpringApplication.run(App, args)
        def app = applicationContext.getBean(App)
        app.run(args)
    }
}
