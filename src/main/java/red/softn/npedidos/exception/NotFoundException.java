package red.softn.npedidos.exception;

import org.springframework.http.HttpStatus;
import red.softn.npedidos.pojo.ErrorDetails;

public class NotFoundException extends DefaultHttpException {
    
    public NotFoundException(ErrorDetails errorDetails) {
        super(HttpStatus.NOT_FOUND, errorDetails);
    }
    
    public NotFoundException(ErrorDetails errorDetails, Throwable cause) {
        super(HttpStatus.NOT_FOUND, errorDetails, cause);
    }
    
    public NotFoundException(String message) {
        this(new ErrorDetails(message));
    }
    
}
