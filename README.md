# Spring Cloud API Gateway Example

An example of API gateway with Spring Cloud.


## Components

- `server`
  - A simple REST server
  - Spring Boot Web
  - Sleuth
  - jackson-dataformat-xml (XML encoder and decoder)
  - Global error handler serving JSON response (`AppErrorController`)
- `api-gateway`
  - A couple of REST server and client
  - Spring Boot Web
  - Feign
  - Hystrix
  - Sleuth
  - Zuul Proxy
  - jackson-dataformat-xml (XML encoder and decoder)
  - API Key Authentication (`WebSecurityConfig`)
- `client`
  - A simple REST client
  - Feign
  - Hystrix
  - Sleuth
