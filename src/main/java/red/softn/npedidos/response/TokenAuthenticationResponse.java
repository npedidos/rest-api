package red.softn.npedidos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TokenAuthenticationResponse {
    
    private String token;
    
    private User user;
    
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class User {
        
        private Integer id;
        
        private String username;
        
    }
    
}
