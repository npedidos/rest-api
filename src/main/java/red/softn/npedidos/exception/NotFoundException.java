package red.softn.npedidos.exception;

import org.springframework.http.HttpStatus;
import red.softn.npedidos.pojo.ErrorDescription;

public class NotFoundException extends DefaultHttpException {
    
    public NotFoundException(ErrorDescription errorDescription) {
        super(HttpStatus.NOT_FOUND, errorDescription);
    }
    
    public NotFoundException(ErrorDescription errorDescription, Throwable cause) {
        super(HttpStatus.NOT_FOUND, errorDescription, cause);
    }
    
}
