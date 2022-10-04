package red.softn.npedidos.service;

import net.datafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.core.ResolvableType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.util.ReflectionUtils;
import red.softn.npedidos.configuration.AppConfig;
import red.softn.npedidos.utils.gson.GsonUtil;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

abstract class CrudServiceTest<E, R, T, ID, U extends CrudServiceTestUtil<E, R, T, ID>> {
    
    private U crudServiceTestUtil;
    
    @Mock
    private GsonUtil gsonUtil;
    
    public abstract CrudService<E, R, T, ID> getService();
    
    public abstract JpaRepository<T, ID> getRepository();
    
    @BeforeEach
    void setUp() {
        this.crudServiceTestUtil = newCrudServiceTestUtil();
    }
    
    private U newCrudServiceTestUtil() {
        try {
            Faker faker = new AppConfig(null, null).faker();
            var accessibleConstructor = ReflectionUtils.accessibleConstructor(getCrudServiceTestUtilClass(), Faker.class);
            
            return accessibleConstructor.newInstance(faker);
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException |
                 IllegalAccessException e) {
            throw new RuntimeException("Error al crear la instancia de la clase CrudServiceTestUtil.");
        }
    }
    
    @SuppressWarnings("unchecked")
    private Class<U> getCrudServiceTestUtilClass() {
        return (Class<U>) ResolvableType.forClass(this.getClass())
                                        .getSuperType()
                                        .resolveGeneric(4);
    }
    
    @SuppressWarnings("unchecked")
    private Class<T> getResponseClass() {
        return (Class<T>) ResolvableType.forClass(this.getClass())
                                        .getSuperType()
                                        .resolveGeneric(1);
    }
    
    @SuppressWarnings("unchecked")
    private Class<T> getEntityClass() {
        return (Class<T>) ResolvableType.forClass(this.getClass())
                                        .getSuperType()
                                        .resolveGeneric(2);
    }
    
    @Test
    void testFindAll() {
        List<T> entityList = this.crudServiceTestUtil.getEntityList();
        List<R> expected = this.crudServiceTestUtil.getResponseList();
        
        when(getRepository().findAll()).thenReturn(entityList);
        when(this.gsonUtil.convertTo(eq(entityList), eq(getResponseClass()))).thenReturn(expected);
        
        List<R> actual = getService().findAll();
        
        assertIterableEquals(expected, actual);
    }
    
    @Test
    void testFindById() {
        ID id = this.crudServiceTestUtil.getId();
        R expected = this.crudServiceTestUtil.getResponse();
        T entity = this.crudServiceTestUtil.getEntity();
        Optional<T> entityOptional = Optional.of(this.crudServiceTestUtil.getEntity());
        
        when(getRepository().findById(eq(id))).thenReturn(entityOptional);
        when(this.gsonUtil.convertTo(eq(entity), eq(getResponseClass()))).thenReturn(expected);
        
        R actual = getService().findById(id);
        
        assertEquals(expected, actual);
    }
    
    @Test
    void testSave() {
        E request = this.crudServiceTestUtil.getRequest();
        R expected = this.crudServiceTestUtil.getResponse();
        T entity = this.crudServiceTestUtil.getEntity();
        T entitySaveResult = this.crudServiceTestUtil.getEntitySaveResult();
        
        when(this.gsonUtil.convertTo(eq(request), eq(getEntityClass()))).thenReturn(entity);
        when(getRepository().save(eq(entity))).thenReturn(entitySaveResult);
        when(this.gsonUtil.convertTo(eq(entitySaveResult), eq(getResponseClass()))).thenReturn(expected);
        
        R actual = getService().save(request);
        
        assertEquals(expected, actual);
    }
    
    @Test
    void testDelete() {
        ID id = this.crudServiceTestUtil.getId();
        
        when(getRepository().existsById(eq(id))).thenReturn(true);
        
        getService().delete(id);
        
        verify(getRepository()).deleteById(eq(id));
    }
    
    @Test
    void testUpdate() {
        R expected = this.crudServiceTestUtil.getResponse();
        ID id = this.crudServiceTestUtil.getId();
        T entity = this.crudServiceTestUtil.getEntity();
        E request = this.crudServiceTestUtil.getRequest();
        
        when(getRepository().existsById(eq(id))).thenReturn(true);
        when(this.gsonUtil.convertTo(eq(request), eq(getEntityClass()))).thenReturn(entity);
        when(getRepository().save(eq(entity))).thenReturn(entity);
        when(this.gsonUtil.convertTo(eq(entity), eq(getResponseClass()))).thenReturn(expected);
        
        R actual = getService().update(id, request);
        
        assertEquals(expected, actual);
    }
    
}
