package red.softn.npedidos.exception;

import org.springframework.http.HttpStatus;
import red.softn.npedidos.pojo.ErrorDescription;

public class InternalServerErrorException extends DefaultHttpException {
    
    public InternalServerErrorException(ErrorDescription errorDescription) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, errorDescription);
    }
    
    public InternalServerErrorException(ErrorDescription errorDescription, Throwable cause) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, errorDescription, cause);
    }
    
}
