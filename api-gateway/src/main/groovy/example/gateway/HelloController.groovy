package example.gateway

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

import javax.inject.Inject

@RestController
class HelloController {
    @Inject
    HelloClient client

    @GetMapping(value = 'hello')
    Hello helloWorld() {
        client.helloWorld()
    }

    @GetMapping(value = '/hello/{name}')
    Hello helloByName(@PathVariable String name) {
        client.helloByName(name)
    }
}
