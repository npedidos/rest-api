package red.softn.npedidos.service;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;
import net.datafaker.Faker;

import java.util.List;

@Getter
@Setter(AccessLevel.PROTECTED)
public abstract class CrudServiceTestUtil<E, R, T, ID> {
    
    private E request;
    
    private R response;
    
    private T entity;
    
    private T entitySaveResult;
    
    private ID id;
    
    private List<R> responseList;
    
    private List<T> entityList;
    
    private Faker faker;
    
    public CrudServiceTestUtil(Faker faker) {
        this.faker = faker;
        setInit();
        this.responseList = List.of(this.response);
        this.entityList = List.of(this.entity);
    }
    
    public abstract Init<E, R, T, ID> init();
    
    public Integer getRandomInteger() {
        return this.faker.random()
                         .nextInt(1, 1000);
    }
    
    public String getRandomWord() {
        return this.faker.lorem()
                         .word();
    }
    
    private void setInit() {
        Init<E, R, T, ID> init = init();
        
        this.request = init.getRequest();
        this.response = init.getResponse();
        this.entity = init.getEntity();
        this.entitySaveResult = init.getEntitySaveResult();
        this.id = init.getId();
    }
    
    @Value(staticConstructor = "of")
    public static class Init<E, R, T, ID> {
        
        E request;
        
        R response;
        
        T entity;
        
        T entitySaveResult;
        
        ID id;
        
    }
    
}
