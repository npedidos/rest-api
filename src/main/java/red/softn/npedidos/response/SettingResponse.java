package red.softn.npedidos.response;

import lombok.Data;

@Data
public class SettingResponse {
    
    private Integer id;
    
    private String keyName;
    
    private String value;
    
    private String description;
    
}
