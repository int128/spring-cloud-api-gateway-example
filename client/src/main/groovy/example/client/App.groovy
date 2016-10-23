package example.client

import groovy.util.logging.Slf4j
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.netflix.feign.EnableFeignClients

import javax.inject.Inject

@Slf4j
@EnableFeignClients
@SpringBootApplication
class App implements CommandLineRunner {
    @Inject
    HelloClient client

    Hello hello(String... args) {
        if (args.length > 0) {
            client.helloByName(args.join(','))
        } else {
            client.helloWorld()
        }
    }

    @Override
    void run(String... args) {
        def hello = hello(args)
        log.info("$hello")
    }

    static void main(String[] args) {
        SpringApplication.run(App, args)
    }
}
