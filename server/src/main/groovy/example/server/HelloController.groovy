package example.server

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(produces = 'application/json')
class HelloController {
    @Autowired
    HelloRepository helloRepository

    @GetMapping('/hello')
    Hello helloWorld() {
        helloRepository.create('world')
    }

    @GetMapping('/hello/{name}')
    Hello helloByName(@PathVariable String name) {
        helloRepository.create(name)
    }

    @GetMapping('/wait/{milliseconds}')
    long waitMillis(@PathVariable long milliseconds) {
        sleep(milliseconds)
        milliseconds
    }

    @GetMapping('/status/{code}')
    void status(@PathVariable int code) {
        throw new AppException(code, "Intentionally $code raised")
    }
}
