package example.gateway.authz

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties(prefix = 'authorities')
class ApiKeys {
    List<String> hello
}
