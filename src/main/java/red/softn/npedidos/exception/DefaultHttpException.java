package red.softn.npedidos.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import red.softn.npedidos.pojo.ErrorDescription;

@Getter
public class DefaultHttpException extends ResponseStatusException {
    
    private final ErrorDescription errorDescription;
    
    public DefaultHttpException(HttpStatus status, ErrorDescription errorDescription) {
        this(status, errorDescription, null);
    }
    
    public DefaultHttpException(int rawStatusCode, ErrorDescription errorDescription) {
        this(rawStatusCode, errorDescription, null);
    }
    
    public DefaultHttpException(HttpStatus status, ErrorDescription errorDescription, Throwable cause) {
        super(status, null, cause);
        this.errorDescription = errorDescription;
    }
    
    public DefaultHttpException(int rawStatusCode, ErrorDescription errorDescription, Throwable cause) {
        super(rawStatusCode, null, cause);
        this.errorDescription = errorDescription;
    }
    
}
