package example.server

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {
    @GetMapping(value = 'hello')
    Hello helloWorld() {
        new Hello('world')
    }

    @GetMapping(value = '/hello/{name}')
    Hello helloByName(@PathVariable String name) {
        new Hello(name)
    }
}
