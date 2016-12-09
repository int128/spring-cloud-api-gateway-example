package example.client

import org.springframework.cloud.netflix.feign.FeignClient
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@FeignClient(name = '${hello.service.name}', url = '${hello.service.url}', configuration = HelloClientConfiguration)
interface HelloClient {
    @RequestMapping(value = '/hello', method = RequestMethod.GET)
    Hello hello()
}
