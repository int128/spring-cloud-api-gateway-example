# Spring Cloud API Gateway Example

An example of API gateway with Spring Cloud.


## Components

- `server`
  - A simple REST server
  - Spring Boot Web
  - Sleuth
  - jackson-dataformat-xml (XML encoder and decoder)
- `api-gateway`
  - A couple of REST server and client
  - Spring Boot Web
  - Feign
  - Hystrix
  - Sleuth
  - Zuul Proxy
  - jackson-dataformat-xml (XML encoder and decoder)
- `client`
  - A simple REST client
  - Feign
  - Hystrix
  - Sleuth
