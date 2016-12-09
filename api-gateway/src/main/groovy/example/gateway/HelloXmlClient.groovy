package example.gateway

import example.feign.HelloClientConfiguration
import org.springframework.cloud.netflix.feign.FeignClient
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@FeignClient(name = 'hello-xml', url = '${hello.service.url}', configuration = HelloClientConfiguration)
interface HelloXmlClient {
    @RequestMapping(value = '/xml/hello', method = RequestMethod.GET, produces = 'application/xml')
    Hello helloWorld()

    @RequestMapping(value = '/xml/hello/{name}', method = RequestMethod.GET, produces = 'application/xml')
    Hello helloByName(@PathVariable('name') String name)
}
