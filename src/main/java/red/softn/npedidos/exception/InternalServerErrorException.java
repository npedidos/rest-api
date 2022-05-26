package red.softn.npedidos.exception;

import org.springframework.http.HttpStatus;
import red.softn.npedidos.pojo.ErrorDetails;

public class InternalServerErrorException extends DefaultHttpException {
    
    public InternalServerErrorException(ErrorDetails errorDetails) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, errorDetails);
    }
    
    public InternalServerErrorException(ErrorDetails errorDetails, Throwable cause) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, errorDetails, cause);
    }
    
}
