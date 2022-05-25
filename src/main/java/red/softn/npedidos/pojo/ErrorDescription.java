package red.softn.npedidos.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDescription {
    
    private String code;
    
    private String description;
    
    public ErrorDescription(String description) {
        this.description = description;
    }
    
}
