package red.softn.npedidos.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PagingAndSortingResponse<R> extends ContentResponse<R> {
    
    private int currentPage;
    
    private int pageSize;
    
    private int totalPages;
    
    private long total;
    
}
