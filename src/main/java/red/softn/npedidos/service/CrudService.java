package red.softn.npedidos.service;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ResolvableType;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.util.ReflectionUtils;
import red.softn.npedidos.exception.NotFoundException;
import red.softn.npedidos.pojo.DataRequestScope;
import red.softn.npedidos.pojo.ErrorDetails;
import red.softn.npedidos.response.PagingAndSortingResponse;
import red.softn.npedidos.utils.gson.GsonUtil;

import java.lang.reflect.Field;
import java.util.List;

@Getter
public abstract class CrudService<E, R, T, ID> implements CrudServiceI<E, R, ID> {
    
    //TODO: por el momento dejo esto asi.
    @Autowired
    private GsonUtil gsonUtil;
    
    @Autowired
    private DataRequestScope dataRequestScope;
    
    protected abstract JpaRepository<T, ID> getRepository();
    
    @Override
    public PagingAndSortingResponse<R> findAllPageable() {
        Page<T> page = getRepository().findAll(this.dataRequestScope.getPageable());
        
        return pageToResponse(page, getResponseClass());
    }
    
    protected <RE, EN> PagingAndSortingResponse<RE> pageToResponse(Page<EN> page, Class<RE> classRE) {
        PagingAndSortingResponse<RE> response = new PagingAndSortingResponse<>();
        List<RE> content = this.gsonUtil.convertTo(page.getContent(), classRE);
        
        response.setContent(content);
        response.setCurrentPage(page.getNumber());
        response.setPageSize(page.getNumberOfElements());
        response.setTotalPages(page.getTotalPages());
        response.setTotal(page.getTotalElements());
        
        return response;
    }
    
    @Deprecated
    public List<R> findAll() {
        Iterable<T> all = getRepository().findAll();
        
        return this.gsonUtil.convertTo(all, getResponseClass());
    }
    
    public R findById(ID id) {
        T entity = getRepository().findById(id)
                                  .orElse(null);
        
        return this.gsonUtil.convertTo(entity, getResponseClass());
    }
    
    public R save(E request) {
        T entity = this.gsonUtil.convertTo(request, getEntityClass());
        
        setFieldId(null, entity);
        
        T save = getRepository().save(entity);
        
        return this.gsonUtil.convertTo(save, getResponseClass());
    }
    
    public void delete(ID id) {
        checkIsExistById(id);
        getRepository().deleteById(id);
    }
    
    public R update(ID id, E typeDish) {
        checkIsExistById(id);
        T entity = this.gsonUtil.convertTo(typeDish, getEntityClass());
        
        setFieldId(id, entity);
        
        T save = getRepository().save(entity);
        
        return this.gsonUtil.convertTo(save, getResponseClass());
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
    
    @SuppressWarnings("unchecked")
    public Class<T> getEntityClass() {
        return (Class<T>) ResolvableType.forClass(this.getClass())
                                        .getSuperType()
                                        .resolveGeneric(2);
    }
    
    @SuppressWarnings("unchecked")
    protected Class<R> getResponseClass() {
        return (Class<R>) ResolvableType.forClass(this.getClass())
                                        .getSuperType()
                                        .resolveGeneric(1);
    }
    
}
