package configuration

import feign.Logger
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class HelloClientConfiguration {
    @Bean
    Logger.Level feignLoggerLevel() {
        Logger.Level.BASIC
    }
}
