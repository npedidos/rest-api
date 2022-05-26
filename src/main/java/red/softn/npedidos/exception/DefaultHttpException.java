package red.softn.npedidos.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import red.softn.npedidos.pojo.ErrorDetails;

@Getter
public class DefaultHttpException extends ResponseStatusException {
    
    private final ErrorDetails errorDetails;
    
    public DefaultHttpException(HttpStatus status, ErrorDetails errorDetails) {
        this(status, errorDetails, null);
    }
    
    public DefaultHttpException(int rawStatusCode, ErrorDetails errorDetails) {
        this(rawStatusCode, errorDetails, null);
    }
    
    public DefaultHttpException(HttpStatus status, ErrorDetails errorDetails, Throwable cause) {
        super(status, null, cause);
        this.errorDetails = errorDetails;
    }
    
    public DefaultHttpException(int rawStatusCode, ErrorDetails errorDetails, Throwable cause) {
        super(rawStatusCode, null, cause);
        this.errorDetails = errorDetails;
    }
    
}
