package red.softn.npedidos.response;

import lombok.Data;

@Data
public class UserResponse {
    
    private Integer id;
    
    private String email;
    
    private String username;
    
    private String password;
    
}
