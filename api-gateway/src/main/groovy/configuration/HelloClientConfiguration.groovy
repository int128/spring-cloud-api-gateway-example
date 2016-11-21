package configuration

import feign.codec.ErrorDecoder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class HelloClientConfiguration {
    @Bean
    ErrorDecoder errorDecoder() {
        new ErrorResponseDecoder()
    }
}
