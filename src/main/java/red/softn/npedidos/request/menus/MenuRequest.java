package red.softn.npedidos.request.menus;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MenuRequest {
    
    private Integer id;
    
    private LocalDate date;
    
}
