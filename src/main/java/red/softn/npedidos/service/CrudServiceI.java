package red.softn.npedidos.service;

import java.util.List;

public interface CrudServiceI<E, R, ID> {
    
    List<R> findAll();
    
    R findById(ID id);
    
    R save(E typeDish);
    
    void delete(ID id);
    
    R update(ID id, E typeDish);
    
}
