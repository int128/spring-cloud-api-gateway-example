package example.gateway

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

import javax.inject.Inject

@RestController
class HelloController {
    @Inject
    HelloClient client

    @GetMapping('/hello')
    Hello helloWorld() {
        client.helloWorld()
    }

    @GetMapping('/hello/{name}')
    Hello helloByName(@PathVariable String name) {
        client.helloByName(name)
    }

    @GetMapping('/wait/{milliseconds}')
    long waitMillis(@PathVariable long milliseconds) {
        client.waitMillis(milliseconds)
    }

    @GetMapping('/status/{code}')
    void status(@PathVariable int code) {
        client.status(code)
    }
}
