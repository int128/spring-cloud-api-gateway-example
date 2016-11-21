package configuration

import groovy.transform.Immutable

@Immutable
class ErrorResponse {
    int code
    String message
}
