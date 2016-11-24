package example.gateway

import org.springframework.cloud.netflix.feign.FeignClient
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@FeignClient(name = '${hello.service.name}', url = '${hello.service.url}')
interface HelloXmlClient {
    @RequestMapping(value = '/xml/hello', method = RequestMethod.GET, produces = 'application/xml')
    Hello helloWorld()

    @RequestMapping(value = '/xml/hello/{name}', method = RequestMethod.GET, produces = 'application/xml')
    Hello helloByName(@PathVariable('name') String name)
}
