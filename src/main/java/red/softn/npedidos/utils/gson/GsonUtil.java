package red.softn.npedidos.utils.gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ResolvableType;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GsonUtil {
    
    private final Gson gson;
    
    public <R> R convertTo(Object object, Class<?> clazz) {
        TypeToken<?> typeToken;
        boolean isList = ResolvableType.forClass(List.class)
                                       .isAssignableFrom(ResolvableType.forInstance(object));
        
        if (isList) {
            typeToken = TypeToken.getParameterized(List.class, clazz);
        } else {
            typeToken = TypeToken.get(clazz);
        }
        
        return gson.fromJson(gson.toJson(object), typeToken.getType());
    }
    
}
