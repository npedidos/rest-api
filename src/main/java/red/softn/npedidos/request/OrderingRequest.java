package red.softn.npedidos.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderingRequest {
    
    private Integer id;
    
    private LocalDateTime dateOrder;
    
}
