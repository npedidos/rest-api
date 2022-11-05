package red.softn.npedidos.request.orders;

import lombok.Data;

import java.util.List;

@Data
public class OrderFoodDishesRequest {
    
    private List<Integer> foodDishesId;
    
}
