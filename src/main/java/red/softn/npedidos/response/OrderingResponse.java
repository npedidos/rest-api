package red.softn.npedidos.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderingResponse {
    
    private Integer id;
    
    private LocalDateTime dateOrder;
    
}
