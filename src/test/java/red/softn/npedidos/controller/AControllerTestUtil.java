package red.softn.npedidos.controller;

import com.google.gson.Gson;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import net.datafaker.Faker;
import org.springframework.core.ResolvableType;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Getter
@Setter(AccessLevel.PROTECTED)
public abstract class AControllerTestUtil<E, R, ID> {
    
    private E request;
    
    private R response;
    
    private ID id;
    
    private final List<R> responseList;
    
    private final String requestJSON;
    
    @Getter(value = AccessLevel.PROTECTED)
    private final Faker faker;
    
    @Getter(value = AccessLevel.PROTECTED)
    private final Gson gson;
    
    public AControllerTestUtil(Faker faker, Gson gson) {
        this.faker = faker;
        this.gson = gson;
        setRequestResponse();
        this.requestJSON = this.gson.toJson(this.request);
        this.responseList = List.of(this.response);
    }
    
    protected abstract List<Object> initRequestResponse();
    
    private void setRequestResponse() {
        Class<?> requestClass = getRequestClass();
        Class<?> responseClass = getResponseClass();
        Class<?> idClass = getIdClass();
        
        initRequestResponse().stream()
                             .forEach(value -> {
                                 ResolvableType resolvableType = ResolvableType.forClass(value.getClass());
            
                                 if (resolvableType.isAssignableFrom(requestClass)) {
                                     this.request = (E) value;
                                 } else if (resolvableType.isAssignableFrom(responseClass)) {
                                     this.response = (R) value;
                                 } else if (resolvableType.isAssignableFrom(idClass)) {
                                     this.id = (ID) value;
                                 }
                             });
    }
    
    private Class<?> getIdClass() {
        return getResolveGeneric(2);
    }
    
    private Class<?> getResponseClass() {
        return getResolveGeneric(1);
    }
    
    private Class<?> getRequestClass() {
        return getResolveGeneric(0);
    }
    
    private Class<?> getResolveGeneric(int index) {
        return ResolvableType.forClass(this.getClass())
                             .getSuperType()
                             .resolveGeneric(index);
    }
    
    public Integer getRandomInteger() {
        return this.faker.random()
                         .nextInt(1, 1000);
    }
    
    public LocalDate getDateFutureDays() {
        return this.faker.date()
                         .future(getRandomInteger(), TimeUnit.DAYS)
                         .toLocalDateTime()
                         .toLocalDate();
    }
    
}
