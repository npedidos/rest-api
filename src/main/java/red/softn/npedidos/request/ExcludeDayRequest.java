package red.softn.npedidos.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ExcludeDayRequest {
    
    private Integer id;
    
    private LocalDate dateExclude;
    
}
