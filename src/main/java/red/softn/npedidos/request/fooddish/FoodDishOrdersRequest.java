package red.softn.npedidos.request.fooddish;

import lombok.Data;

import java.util.List;

@Data
public class FoodDishOrdersRequest {
    
    private List<Integer> ordersId;
    
}
