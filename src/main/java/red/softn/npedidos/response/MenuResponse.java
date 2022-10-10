package red.softn.npedidos.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MenuResponse {
    
    private Integer id;
    
    private LocalDate date;
    
}
