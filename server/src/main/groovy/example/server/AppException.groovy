package example.server

class AppException extends RuntimeException {
    final int status

    def AppException(int status, String message) {
        super(message)
        this.status = status
    }

    def AppException(int status, String message, Throwable cause) {
        super(message, cause)
        this.status = status
    }
}
