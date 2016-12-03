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
  - OAuth 2.0 Client with Client Credential Grant
- `client`
  - A simple REST client
  - Feign
  - Hystrix
  - Sleuth


## URLs

- `http://localhost:8081` (server) provides APIs without authentication
- `http://localhost:8082` (api-gateway) provides APIs without authentication
- `http://localhost:8082/twitter/search/{query}` (api-gateway) provides Twitter Search API


## How to Run

Put credential into `/api-gateway/src/main/resources/config/application.yml` as follows:

```yaml
security:
  oauth2:
    twitter:
      client-id: TWITTER-API-YOUR-CLIENT-ID
      client-secret: TWITTER-API-YOUR-CLIENT-SECRET
```

