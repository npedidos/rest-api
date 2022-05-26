package red.softn.npedidos.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.util.ReflectionUtils;
import red.softn.npedidos.exception.NotFoundException;
import red.softn.npedidos.pojo.ErrorDetails;

import java.lang.reflect.Field;
import java.util.List;

public abstract class CrudService<T, ID> {
    
    protected abstract CrudRepository<T, ID> getRepository();
    
    public List<T> findAll() {
        return (List<T>) getRepository().findAll();
    }
    
    public T findById(ID id) {
        return getRepository().findById(id)
                              .orElse(null);
    }
    
    public T save(T typeDish) {
        setFieldId(null, typeDish);
        
        return getRepository().save(typeDish);
    }
    
    public void delete(ID id) {
        checkIsExistById(id);
        getRepository().deleteById(id);
    }
    
    public T update(ID id, T typeDish) {
        checkIsExistById(id);
        setFieldId(id, typeDish);
        
        return getRepository().save(typeDish);
    }
    
    private void checkIsExistById(ID id) {
        if (!getRepository().existsById(id)) {
            throw new NotFoundException(new ErrorDetails("El registro no existe"));
        }
    }
    
    private void setFieldId(ID id, T typeDish) {
        Field field = ReflectionUtils.findField(typeDish.getClass(), "id");
        
        if (field != null) {
            ReflectionUtils.makeAccessible(field);
            ReflectionUtils.setField(field, typeDish, id);
        }
    }
    
}
