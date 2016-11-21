package configuration

import feign.Response
import feign.codec.Decoder
import feign.codec.ErrorDecoder
import groovy.util.logging.Slf4j

import javax.inject.Inject

@Slf4j
class ErrorResponseDecoder implements ErrorDecoder {
    @Inject
    Decoder decoder

    @Override
    Exception decode(String methodKey, Response response) {
        def errorResponse = decoder.decode(response, ErrorResponse) as ErrorResponse
        new ErrorResponseException(response.status(), errorResponse)
    }
}
