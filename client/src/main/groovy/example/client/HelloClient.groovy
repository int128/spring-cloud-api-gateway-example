package example.client

import org.springframework.cloud.netflix.feign.FeignClient
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@FeignClient(name = 'hello-service', url = 'http://localhost:8082')
interface HelloClient {
    @RequestMapping(value = '/hello', method = RequestMethod.GET)
    Hello helloWorld()

    @RequestMapping(value = '/hello/{name}', method = RequestMethod.GET)
    Hello helloByName(@PathVariable('name') String name)
}
