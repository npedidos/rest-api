package red.softn.npedidos.request.menus;

import lombok.Data;

import java.util.List;

@Data
public class MenuFoodDishesSaveRequest {
    
    private List<Integer> foodDishes;
    
}
