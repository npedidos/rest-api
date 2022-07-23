package red.softn.npedidos.configuration;

import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
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
        ErrorDetails errorDetails = new ErrorDetails();
        String errorMessage = (String) webRequest.getAttribute(RequestDispatcher.ERROR_MESSAGE, 0);
        
        if (Objects.isNull(errorMessage)) {
            Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, options);
            String status = getValue(errorAttributes, "status");
            String error = getValue(errorAttributes, "error");
            
            errorDetails.setCode(StringUtils.defaultIfBlank(status, "500"));
            errorDetails.setDescription(StringUtils.defaultIfBlank(error, "Error desconocido"));
        }
        
        return this.gsonUtil.convertTo(new ErrorResponse(errorDetails), Map.class);
    }
    
    private String getValue(Map<String, Object> map, String key) {
        return map.containsKey(key) ? String.valueOf(map.get(key)) : "";
    }
    
}
