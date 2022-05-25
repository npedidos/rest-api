package red.softn.npedidos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import red.softn.npedidos.pojo.ErrorDescription;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
    
    private ErrorDescription error;
    
}
