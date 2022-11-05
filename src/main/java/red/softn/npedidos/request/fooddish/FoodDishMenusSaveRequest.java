package red.softn.npedidos.request.fooddish;

import lombok.Data;

import java.util.List;

@Data
public class FoodDishMenusSaveRequest {
    
    private List<Integer> menusId;
    
}
