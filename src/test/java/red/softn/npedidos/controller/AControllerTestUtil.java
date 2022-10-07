package red.softn.npedidos.controller;

import com.google.gson.Gson;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;
import net.datafaker.Faker;

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
        setInit();
        this.requestJSON = this.gson.toJson(this.request);
        this.responseList = List.of(this.response);
    }
    
    protected abstract Init<E, R, ID> init();
    
    private void setInit() {
        Init<E, R, ID> init = init();
        this.request = init.getRequest();
        this.response = init.getResponse();
        this.id = init.getId();
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
    
    @Value(staticConstructor = "of")
    public static class Init<E, R, ID> {
        
        E request;
        
        R response;
        
        ID id;
        
    }
    
}
