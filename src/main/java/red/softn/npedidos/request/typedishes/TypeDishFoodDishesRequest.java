package red.softn.npedidos.request.typedishes;

import lombok.Data;
import red.softn.npedidos.request.fooddish.FoodDishRequest;

import java.util.List;

@Data
public class TypeDishFoodDishesRequest {
    
    private List<FoodDishRequest> foodDishes;
    
}
