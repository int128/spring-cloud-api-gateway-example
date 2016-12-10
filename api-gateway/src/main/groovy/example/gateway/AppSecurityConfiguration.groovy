package example.gateway

import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationProvider
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken
import org.springframework.security.web.authentication.preauth.RequestHeaderAuthenticationFilter
import org.springframework.stereotype.Component

@Configuration
@EnableWebSecurity
class AppSecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Slf4j
    @Component
    static class MyUserDetailsService implements AuthenticationUserDetailsService<PreAuthenticatedAuthenticationToken> {
        @Override
        UserDetails loadUserDetails(PreAuthenticatedAuthenticationToken token) {
            new User(token.principal.toString(), '', [])
        }
    }

    @Autowired
    private MyUserDetailsService myUserDetailsService

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        def provider = new PreAuthenticatedAuthenticationProvider()
        provider.preAuthenticatedUserDetailsService = myUserDetailsService
        auth.authenticationProvider(provider)
    }

    @Override
    protected void configure(HttpSecurity http) {
        def requestHeaderAuthenticationFilter = new RequestHeaderAuthenticationFilter()
        requestHeaderAuthenticationFilter.principalRequestHeader = 'x-user'
        requestHeaderAuthenticationFilter.exceptionIfHeaderMissing = false
        requestHeaderAuthenticationFilter.authenticationManager = authenticationManager()
        http.addFilter(requestHeaderAuthenticationFilter)

        http.authorizeRequests().anyRequest().permitAll()
    }
}
