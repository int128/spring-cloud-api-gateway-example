package example.gateway

import org.springframework.cloud.netflix.feign.FeignClient
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@FeignClient(name = '${hello.service.name}', url = '${hello.service.url}')
interface HelloClient {
    @RequestMapping(value = '/hello', method = RequestMethod.GET)
    Hello helloWorld()

    @RequestMapping(value = '/hello/{name}', method = RequestMethod.GET)
    Hello helloByName(@PathVariable('name') String name)

    @RequestMapping(value = '/wait/{milliseconds}', method = RequestMethod.GET)
    long waitMillis(@PathVariable('milliseconds') long milliseconds)

    @RequestMapping(value = '/status/{code}', method = RequestMethod.GET)
    ResponseEntity status(@PathVariable('code') int code)
}
