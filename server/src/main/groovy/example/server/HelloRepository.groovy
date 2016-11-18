package example.server

import groovy.util.logging.Slf4j
import org.springframework.stereotype.Repository

@Slf4j
@Repository
class HelloRepository {
    Hello create(String name) {
        log.info("Creating a hello object: $name")
        new Hello(name)
    }
}
