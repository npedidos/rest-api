package red.softn.npedidos.controller;

import com.google.gson.Gson;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Value;
import net.datafaker.Faker;
import red.softn.npedidos.TestUtil;

import java.util.List;

@Getter
public abstract class AControllerTestUtil<E, R, ID> extends TestUtil {
    
    private E request;
    
    private R response;
    
    private ID id;
    
    private final List<R> responseList;
    
    private final String requestJSON;
    
    @Getter(value = AccessLevel.PROTECTED)
    private final Gson gson;
    
    public AControllerTestUtil(Faker faker, Gson gson) {
        super(faker);
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
    
    @Value(staticConstructor = "of")
    public static class Init<E, R, ID> {
        
        E request;
        
        R response;
        
        ID id;
        
    }
    
}
