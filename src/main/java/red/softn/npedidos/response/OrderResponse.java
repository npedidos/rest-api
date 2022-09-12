package red.softn.npedidos.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderResponse {
    
    private Integer id;
    
    private LocalDateTime dateOrder;
    
}
