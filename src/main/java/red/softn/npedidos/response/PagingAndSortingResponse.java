package red.softn.npedidos.response;

import lombok.Data;

import java.util.List;

@Data
public class PagingAndSortingResponse<R> {
    
    private List<R> content;
    
    private int currentPage;
    
    private int pageSize;
    
    private int totalPages;
    
    private long total;
    
}
