package example.gateway

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.netflix.feign.EnableFeignClients

@EnableFeignClients
@SpringBootApplication
class App {
    static void main(String[] args) {
        SpringApplication.run(App, args)
    }
}
