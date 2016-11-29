package example.gateway.authz

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.GrantedAuthority
import org.springframework.stereotype.Component

@Component
class HelloAuthority implements GrantedAuthority {
    @Autowired
    ApiKeys apiKeys

    @Override
    String getAuthority() {
        'HELLO'
    }

    boolean checkApiKey(String apiKey) {
        apiKey in apiKeys.hello
    }
}
