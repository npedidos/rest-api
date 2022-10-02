package red.softn.npedidos.service;

import red.softn.npedidos.response.PagingAndSortingResponse;

import java.util.List;

public interface CrudServiceI<E, R, ID> {
    
    PagingAndSortingResponse<R> findAll(String filter);
    
    List<R> findAll();
    
    R findById(ID id);
    
    R save(E typeDish);
    
    void delete(ID id);
    
    R update(ID id, E typeDish);
    
}
