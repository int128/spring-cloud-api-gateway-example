package example.client

import org.springframework.cloud.netflix.feign.FeignClient
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@FeignClient(name = '${hello.service.name}', url = '${hello.service.url}')
interface HelloClient {
    @RequestMapping(value = '/wait/{milliseconds}', method = RequestMethod.GET)
    long waitMillis(@PathVariable('milliseconds') long milliseconds)
}
