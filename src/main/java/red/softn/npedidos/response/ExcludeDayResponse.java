package red.softn.npedidos.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ExcludeDayResponse {
    
    private Integer id;
    
    private LocalDate dateExclude;
    
}
