package red.softn.npedidos.request.users;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class UserOrdersSaveRequest {
    
    private LocalDateTime dateOrder;
    
    private List<Integer> foodDishesId;
    
}
