package red.softn.npedidos.controller.spring;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Getter;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * Ver {@link BasicErrorController}
 */
@Controller
@RequestMapping("/error")
public class CustomBasicErrorController extends AbstractErrorController {
    
    @Getter
    private final ErrorProperties errorProperties;
    
    public CustomBasicErrorController(ErrorAttributes errorAttributes, ErrorProperties errorProperties, List<ErrorViewResolver> errorViewResolvers) {
        super(errorAttributes, errorViewResolvers);
        Assert.notNull(errorProperties, "ErrorProperties must not be null");
        this.errorProperties = errorProperties;
    }
    
    @RequestMapping
    public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {
        HttpStatus status = getStatus(request);
        
        if (status == HttpStatus.NO_CONTENT) {
            return new ResponseEntity<>(status);
        }
        
        Map<String, Object> body = getErrorAttributes(request, getErrorAttributeOptions(request));
        
        return new ResponseEntity<>(body, status);
    }
    
    protected ErrorAttributeOptions getErrorAttributeOptions(HttpServletRequest request) {
        ErrorAttributeOptions options = ErrorAttributeOptions.defaults();
        
        if (this.errorProperties.isIncludeException()) {
            options = options.including(ErrorAttributeOptions.Include.EXCEPTION);
        }
        
        if (isIncludeStackTrace(request)) {
            options = options.including(ErrorAttributeOptions.Include.STACK_TRACE);
        }
        
        if (isIncludeMessage(request)) {
            options = options.including(ErrorAttributeOptions.Include.MESSAGE);
        }
        
        if (isIncludeBindingErrors(request)) {
            options = options.including(ErrorAttributeOptions.Include.BINDING_ERRORS);
        }
        
        return options;
    }
    
    protected boolean isIncludeMessage(HttpServletRequest request) {
        return switch (getErrorProperties().getIncludeMessage()) {
            case ALWAYS -> true;
            case ON_PARAM -> getMessageParameter(request);
            default -> false;
        };
    }
    
    protected boolean isIncludeBindingErrors(HttpServletRequest request) {
        return switch (getErrorProperties().getIncludeBindingErrors()) {
            case ALWAYS -> true;
            case ON_PARAM -> getErrorsParameter(request);
            default -> false;
        };
    }
    
    protected boolean isIncludeStackTrace(HttpServletRequest request) {
        return switch (getErrorProperties().getIncludeStacktrace()) {
            case ALWAYS -> true;
            case ON_PARAM -> getTraceParameter(request);
            default -> false;
        };
    }
    
}
