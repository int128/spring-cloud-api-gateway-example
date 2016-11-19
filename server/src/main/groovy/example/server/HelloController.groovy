package example.server

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {
    @Autowired
    HelloRepository helloRepository

    @GetMapping('/hello')
    Hello helloWorld() {
        helloRepository.create('world')
    }

    @GetMapping('/hello/{name}')
    Hello helloByName(@PathVariable String name) {
        helloRepository.create('name')
    }

    @GetMapping('/wait/{milliseconds}')
    long waitMillis(@PathVariable long milliseconds) {
        sleep(milliseconds)
        milliseconds
    }

    @GetMapping('/status/{code}')
    ResponseEntity status(@PathVariable int code) {
        def httpStatus = HttpStatus.valueOf(code)
        new ResponseEntity(httpStatus, httpStatus)
    }
}
