package red.softn.npedidos.configuration;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import red.softn.npedidos.exception.DefaultHttpException;
import red.softn.npedidos.pojo.ErrorDescription;
import red.softn.npedidos.response.ErrorResponse;

@RestControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {
    
    @ExceptionHandler(DefaultHttpException.class)
    public ResponseEntity<Object> handleException(DefaultHttpException ex) {
        return ResponseEntity.status(ex.getStatus())
                             .body(new ErrorResponse(ex.getErrorDescription()));
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(Exception ex) {
        ErrorDescription errorDescription = new ErrorDescription(ex.getMessage());
        
        return ResponseEntity.internalServerError()
                             .body(new ErrorResponse(errorDescription));
    }
    
    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ErrorDescription errorDescription = new ErrorDescription(ex.getMessage());
        
        return ResponseEntity.status(status)
                             .body(new ErrorResponse(errorDescription));
    }
    
}
