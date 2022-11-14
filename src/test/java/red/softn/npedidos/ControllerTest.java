package red.softn.npedidos;

import com.google.gson.Gson;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import red.softn.npedidos.configuration.AppProperties;
import red.softn.npedidos.pojo.DataRequestScope;
import red.softn.npedidos.utils.gson.GsonConfig;
import red.softn.npedidos.utils.gson.GsonUtil;

@Import({
    GsonConfig.class,
    AppProperties.class,
    DataRequestScope.class
})
@Getter
public abstract class ControllerTest {
    
    @MockBean
    private GsonUtil gsonUtil;
    
    @Autowired
    private MockMvc mockMvc;
    
    @Autowired
    private Gson gson;
    
    public abstract String getUrlMapping();
    
    public String getUrlMapping(String... urls) {
        return getUrlMapping() + String.join("", urls);
    }
    
}
