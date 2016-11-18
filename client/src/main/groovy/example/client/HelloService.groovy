package example.client

import org.springframework.stereotype.Service

import javax.inject.Inject

@Service
class HelloService {
    @Inject
    HelloClient client

    Hello hello(String... args) {
        if (args.length > 0) {
            client.helloByName(args.join(','))
        } else {
            client.helloWorld()
        }
    }
}
