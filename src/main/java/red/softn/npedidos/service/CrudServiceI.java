package red.softn.npedidos.service;

import red.softn.npedidos.response.PagingAndSortingResponse;

public interface CrudServiceI<E, R, ID> {
    
    PagingAndSortingResponse<R> findAllPageable();
    
    R findById(ID id);
    
    R save(E typeDish);
    
    void delete(ID id);
    
    R update(ID id, E typeDish);
    
}
