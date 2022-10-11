package red.softn.npedidos;

import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.util.ReflectionUtils;
import red.softn.npedidos.service.CrudServiceI;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.jwt;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public abstract class CrudControllerTest<E, R, ID, T extends ControllerTestUtil<E, R, ID>> extends ControllerTest {
    
    private T controllerTestUtil;
    
    public abstract CrudServiceI<E, R, ID> getService();
    
    private String urlMappingId() {
        return getUrlMapping() + "/{id}";
    }
    
    private Class<?> getControllerTestUtilClass() {
        return TestUtil.resolveGeneric(getClass(), 3);
    }
    
    @SuppressWarnings("unchecked")
    private T newInstanceControllerTestUtil() {
        try {
            Class<T> controllerTestUtilClass = (Class<T>) getControllerTestUtilClass();
            var accessibleConstructor = ReflectionUtils.accessibleConstructor(controllerTestUtilClass, Gson.class);
            
            return accessibleConstructor.newInstance(getGson());
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException |
                 IllegalAccessException e) {
            throw new RuntimeException("Error al crear la instancia de la clase ControllerTestUtil.");
        }
    }
    
    @BeforeEach
    public void setUp() {
        this.controllerTestUtil = newInstanceControllerTestUtil();
    }
    
    @Test
    void testFindAllStatusIsOk() throws Exception {
        List<R> response = this.controllerTestUtil.getResponseList();
        
        when(getService().findAll()).thenReturn(response);
        
        var requestBuilder = get(getUrlMapping()).with(jwt());
        
        getMockMvc().perform(requestBuilder)
                    .andExpect(status().isOk());
    }
    
    @Test
    void testFindByIdStatusIsOk() throws Exception {
        ID id = this.controllerTestUtil.getId();
        R response = this.controllerTestUtil.getResponse();
        
        when(getService().findById(eq(id))).thenReturn(response);
        
        var requestBuilder = get(urlMappingId(), id).with(jwt());
        
        getMockMvc().perform(requestBuilder)
                    .andExpect(status().isOk());
    }
    
    @Test
    void testSaveStatusIsCreated() throws Exception {
        var response = this.controllerTestUtil.getResponse();
        var request = this.controllerTestUtil.getRequest();
        String requestJSON = this.controllerTestUtil.getRequestJSON();
        
        when(getService().save(eq(request))).thenReturn(response);
        
        var requestBuilder = post(getUrlMapping()).with(jwt())
                                                  .contentType(MediaType.APPLICATION_JSON)
                                                  .content(requestJSON);
        
        getMockMvc().perform(requestBuilder)
                    .andExpect(status().isCreated());
    }
    
    @Test
    void testUpdateStatusIsOk() throws Exception {
        var request = this.controllerTestUtil.getRequest();
        var response = this.controllerTestUtil.getResponse();
        var requestJSON = this.controllerTestUtil.getRequestJSON();
        ID id = this.controllerTestUtil.getId();
        
        when(getService().update(eq(id), eq(request))).thenReturn(response);
        
        var requestBuilder = put(urlMappingId(), id).with(jwt())
                                                    .contentType(MediaType.APPLICATION_JSON)
                                                    .content(requestJSON);
        
        getMockMvc().perform(requestBuilder)
                    .andExpect(status().isOk());
    }
    
    @Test
    void testDeleteStatusIsNoContent() throws Exception {
        ID id = this.controllerTestUtil.getId();
        
        var requestBuilder = delete(urlMappingId(), id).with(jwt());
        
        getMockMvc().perform(requestBuilder)
                    .andExpect(status().isNoContent());
        
        verify(getService()).delete(eq(id));
    }
    
}
