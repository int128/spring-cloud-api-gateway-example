package example.server

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.web.ErrorAttributes
import org.springframework.boot.autoconfigure.web.ErrorController
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.context.request.ServletRequestAttributes

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@RestController
@RequestMapping(produces = 'application/json')
class AppErrorController implements ErrorController {
    @Autowired
    ErrorAttributes errorAttributes

    @Value('${debug}')
    boolean debug

    @RequestMapping('/error')
    Map<String, Object> error(HttpServletRequest request, HttpServletResponse response) {
        def servletRequestAttributes = new ServletRequestAttributes(request)
        def attributes = errorAttributes.getErrorAttributes(servletRequestAttributes, debug)
        def cause = errorAttributes.getError(servletRequestAttributes)
        if (cause instanceof AppException) {
            response.status = cause.status
            attributes.status = cause.status
            attributes.error = HttpStatus.valueOf(cause.status).reasonPhrase
            attributes.message = cause.message
        }
        attributes
    }

    @Override
    String getErrorPath() {
        '/error'
    }
}
