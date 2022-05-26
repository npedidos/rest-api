package red.softn.npedidos.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetails {
    
    private String code;
    
    private String description;
    
    public ErrorDetails(String description) {
        this.description = description;
    }
    
}
