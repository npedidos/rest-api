package red.softn.npedidos.request.menus;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class MenuRequest {
    
    private Integer id;
    
    private LocalDate date;
    
    private List<Integer> foodDishesId;
    
}
