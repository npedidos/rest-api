package red.softn.npedidos.configuration;

import lombok.AllArgsConstructor;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;
import red.softn.npedidos.pojo.ErrorDetails;
import red.softn.npedidos.response.ErrorResponse;

import javax.servlet.RequestDispatcher;
import java.util.Map;
import java.util.Objects;

@Component
@AllArgsConstructor
public class CustomDefaultErrorAttribute extends DefaultErrorAttributes {
    
    private final GsonUtil gsonUtil;
    
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
        String errorMessage = (String) webRequest.getAttribute(RequestDispatcher.ERROR_MESSAGE, 0);
        
        if (Objects.isNull(errorMessage)) {
            return null;
        }
        
        ErrorDetails errorDetails = new ErrorDetails(errorMessage);
        
        return this.gsonUtil.convertTo(new ErrorResponse(errorDetails), Map.class);
    }
    
}
