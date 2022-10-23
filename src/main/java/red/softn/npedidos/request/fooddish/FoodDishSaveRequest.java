package red.softn.npedidos.request.fooddish;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodDishSaveRequest {
    
    private String name;
    
    private Integer typeDishId;
    
}
