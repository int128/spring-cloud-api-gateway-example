package example.gateway

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(produces = 'application/xml')
class HelloXmlController {
    @Autowired
    HelloXmlClient client

    @GetMapping('/xml/hello')
    Hello helloWorld() {
        client.helloWorld()
    }

    @GetMapping('/xml/hello/{name}')
    Hello helloByName(@PathVariable String name) {
        client.helloByName(name)
    }
}
