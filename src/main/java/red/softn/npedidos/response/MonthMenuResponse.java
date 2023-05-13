package red.softn.npedidos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
public class MonthMenuResponse {
    
    private List<Menu> menus;
    
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Menu {
        
        private Integer id;
        
        private LocalDate date;
        
    }
    
}
