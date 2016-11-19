package example.client

import org.springframework.stereotype.Service

import javax.inject.Inject

@Service
class HelloService {
    @Inject
    HelloClient client

    void hello(String... args) {
        client.waitMillis(3000)
    }
}
