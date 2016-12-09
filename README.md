# Spring Cloud API Gateway Example

An example of API gateway with Spring Cloud.


- API server
  - Spring Boot web server running on port 8081
  - Enable request logging (`CommonsRequestLoggingFilter`)
  - Enable OAuth authorization server
  - Enable OAuth resource server
  - Configure OAuth client ID and secret
  - Configure resource owner user and password
  - Global exception handler
  - Example REST/JSON controller
  - Example REST/XML controller
- API gateway
  - Spring Boot web server running on port 8082
  - Enable request logging (`CommonsRequestLoggingFilter`)
  - Enable access token request logging
  - Enable Feign client
  - Enable Feign client logging
  - Disable Hystrix
  - Enable Feign request interceptor for OAuth 2.0 client (`OAuth2FeignRequestInterceptor`)
  - Example REST controller
- API client
  - Spring Boot without web server
  - Enable access token request logging
  - Enable Feign client
  - Enable Feign client logging
  - Disable Hystrix
  - Enable Feign request interceptor for OAuth 2.0 client (`OAuth2FeignRequestInterceptor`)
  - Example REST client for the API server using resource owner password grant
  - Example REST client for Twitter API using client credentials grant
