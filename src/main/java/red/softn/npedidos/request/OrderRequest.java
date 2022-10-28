package red.softn.npedidos.request;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderRequest {
    
    private Integer id;
    
    private LocalDateTime dateOrder;
    
    private List<Integer> foodDishesId;
    
    private Integer userId;
    
}
