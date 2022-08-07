package red.softn.npedidos.request;

import lombok.Data;

@Data
public class UserRequest {
    
    private Integer id;
    
    private String email;
    
    private String username;
    
    private String password;
    
}
