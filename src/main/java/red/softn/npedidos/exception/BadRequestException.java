package red.softn.npedidos.exception;

import org.springframework.http.HttpStatus;
import red.softn.npedidos.pojo.ErrorDetails;

public class BadRequestException extends DefaultHttpException {
    
    public BadRequestException(ErrorDetails errorDetails) {
        super(HttpStatus.BAD_REQUEST, errorDetails);
    }
    
    public BadRequestException(ErrorDetails errorDetails, Throwable cause) {
        super(HttpStatus.BAD_REQUEST, errorDetails, cause);
    }
    
    public BadRequestException(String message) {
        this(new ErrorDetails(message));
    }
    
}
