package configuration

import feign.RequestInterceptor
import feign.codec.ErrorDecoder
import org.springframework.cloud.security.oauth2.client.feign.OAuth2FeignRequestInterceptor
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.oauth2.client.OAuth2ClientContext
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails
import org.springframework.security.oauth2.common.AuthenticationScheme

@Configuration
class HelloClientConfiguration {
    @Bean
    ErrorDecoder errorDecoder() {
        new ErrorResponseDecoder()
    }

    @Bean
    RequestInterceptor oauth2FeignRequestInterceptor(OAuth2ClientContext oauth2ClientContext){
        new OAuth2FeignRequestInterceptor(oauth2ClientContext, resource())
    }

    @Bean
    OAuth2ProtectedResourceDetails resource() {
        def details = new ResourceOwnerPasswordResourceDetails()
        details.accessTokenUri = '/oauth/token'
        details.clientAuthenticationScheme = AuthenticationScheme.header
        details.clientId = 'client'
        details.clientSecret = 'secret'
        details.username = 'user'
        details.password = '754727e4-750f-451b-ac14-f03a8532ddcd'
        details
    }
}
