package example.gateway

import com.netflix.hystrix.exception.HystrixRuntimeException
import configuration.ErrorResponse
import configuration.ErrorResponseException
import groovy.util.logging.Slf4j
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@Slf4j
@ControllerAdvice
class ResponseStatusPropagation {
    @ExceptionHandler(HystrixRuntimeException)
    ResponseEntity handleHystrixRuntimeException(HystrixRuntimeException e) {
        log.error("Handled the exception by $ResponseStatusPropagation", e)
        if (e.cause instanceof ErrorResponseException) {
            def cause = e.cause as ErrorResponseException
            ResponseEntity
                .status(cause.status())
                .contentType(MediaType.APPLICATION_JSON)
                .body(cause.errorResponse)
        } else {
            ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorResponse(500, e.localizedMessage))
        }
    }
}
