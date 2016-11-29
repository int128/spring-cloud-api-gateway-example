package example.gateway.authz

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationProvider
import org.springframework.security.web.authentication.preauth.RequestHeaderAuthenticationFilter

@Configuration
@EnableWebSecurity
class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    ApiKeyAuthenticationService apiKeyAuthenticationService

    @Autowired
    HelloAuthority helloAuthority

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        def provider = new PreAuthenticatedAuthenticationProvider()
        provider.preAuthenticatedUserDetailsService = apiKeyAuthenticationService
        auth.authenticationProvider(provider)
    }

    @Override
    protected void configure(HttpSecurity http) {
        def requestHeaderAuthenticationFilter = new RequestHeaderAuthenticationFilter()
        requestHeaderAuthenticationFilter.principalRequestHeader = 'x-api-key'
        requestHeaderAuthenticationFilter.exceptionIfHeaderMissing = false
        requestHeaderAuthenticationFilter.authenticationManager = authenticationManager()
        http.addFilter(requestHeaderAuthenticationFilter)

        http.authorizeRequests()
            .antMatchers('/hello/**').hasAuthority(helloAuthority.authority)
            .anyRequest().permitAll()
    }
}
