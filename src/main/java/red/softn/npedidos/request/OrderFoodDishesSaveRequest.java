package red.softn.npedidos.request;

import lombok.Data;

import java.util.List;

@Data
public class OrderFoodDishesSaveRequest {
    
    private List<Integer> foodDishesId;
    
}
