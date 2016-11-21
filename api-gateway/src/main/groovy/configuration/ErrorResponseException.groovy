package configuration

import feign.FeignException

class ErrorResponseException extends FeignException {
    final ErrorResponse errorResponse

    def ErrorResponseException(int status, ErrorResponse errorResponse1) {
        super(status, errorResponse1.toString())
        errorResponse = errorResponse1
    }
}
