package red.softn.npedidos.response.placeorder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlaceOrderResponse {
    
    private Menu menu;
    
    private MenuWeek menuWeek;
    
    private List<TypeDish> typeDishes;
    
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class TypeDish {
        
        private Integer id;
        
        private String name;
        
        private List<FoodDish> foodDishes;
        
    }
    
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class FoodDish {
        
        private Integer id;
        
        private String name;
        
    }
    
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MenuWeek {
        
        private Integer weekOfYear;
        
        private Integer fistDayOfWeek;
        
        private Integer lastDayOfWeek;
        
        private Integer nextWeekMenuId;
        
        private Integer previousWeekMenuId;
        
    }
    
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Menu {
        
        private Integer id;
        
        private LocalDate currentDate;
        
        private Integer nextMenuId;
        
        private Integer previousMenuId;
        
    }
    
}
