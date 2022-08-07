package red.softn.npedidos.request;

import lombok.Data;

@Data
public class SettingRequest {
    
    private Integer id;
    
    private String keyName;
    
    private String value;
    
    private String description;
    
}
