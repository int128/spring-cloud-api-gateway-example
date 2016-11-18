package example.server

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {
    @Autowired
    HelloRepository helloRepository

    @GetMapping(value = 'hello')
    Hello helloWorld() {
        helloRepository.create('world')
    }

    @GetMapping(value = '/hello/{name}')
    Hello helloByName(@PathVariable String name) {
        helloRepository.create('name')
    }
}
