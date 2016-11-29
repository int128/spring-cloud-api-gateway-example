package example.gateway.authz

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken
import org.springframework.stereotype.Service

@Service
class ApiKeyAuthenticationService implements AuthenticationUserDetailsService<PreAuthenticatedAuthenticationToken> {
    @Autowired
    HelloAuthority helloAuthority

    @Override
    UserDetails loadUserDetails(PreAuthenticatedAuthenticationToken token) {
        def apiKey = token.principal as String
        if (helloAuthority.checkApiKey(apiKey)) {
            new User(helloAuthority.authority, apiKey, [helloAuthority])
        } else {
            throw new UsernameNotFoundException("Unknown API key: $apiKey")
        }
    }
}
