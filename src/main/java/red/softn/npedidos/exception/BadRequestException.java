package red.softn.npedidos.exception;

import org.springframework.http.HttpStatus;
import red.softn.npedidos.pojo.ErrorDescription;

public class BadRequestException extends DefaultHttpException {
    
    public BadRequestException(ErrorDescription errorDescription) {
        super(HttpStatus.BAD_REQUEST, errorDescription);
    }
    
    public BadRequestException(ErrorDescription errorDescription, Throwable cause) {
        super(HttpStatus.BAD_REQUEST, errorDescription, cause);
    }
    
}
