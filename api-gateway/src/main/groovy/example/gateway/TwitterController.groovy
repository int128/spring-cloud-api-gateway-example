package example.gateway

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import javax.inject.Inject

@RestController
@RequestMapping(produces = 'application/json')
class TwitterController {
    @Inject
    TwitterClient client

    @GetMapping('/twitter/search/{query}')
    TwitterSearch search(@PathVariable String query) {
        client.search(query)
    }
}
