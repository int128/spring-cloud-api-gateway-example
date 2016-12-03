package example.gateway

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.netflix.feign.EnableFeignClients
import org.springframework.cloud.netflix.zuul.EnableZuulProxy
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client

@EnableFeignClients
@EnableOAuth2Client
@EnableZuulProxy
@SpringBootApplication
class App {
    static void main(String[] args) {
        SpringApplication.run(App, args)
    }
}
