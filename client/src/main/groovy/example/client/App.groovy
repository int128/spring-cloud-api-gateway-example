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
    HelloClient helloClient

    void run(String... args) {
        def hello = helloClient.hello()
        log.info("Received from API server: $hello")
    }

    static void main(String[] args) {
        def applicationContext = SpringApplication.run(App, args)
        def app = applicationContext.getBean(App)
        app.run(args)
    }
}
