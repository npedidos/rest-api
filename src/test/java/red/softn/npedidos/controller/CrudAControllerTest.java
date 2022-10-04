package red.softn.npedidos.controller;

import com.google.gson.Gson;
import lombok.Getter;
import net.datafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Import;
import org.springframework.core.ResolvableType;
import org.springframework.http.MediaType;
import org.springframework.util.ReflectionUtils;
import red.softn.npedidos.configuration.AppProperties;
import red.softn.npedidos.service.CrudServiceI;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.jwt;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Import({AppProperties.class})
@Getter
public abstract class CrudAControllerTest<E, R, ID, T extends AControllerTestUtil<E, R, ID>> extends AControllerTest {
    
    private T controllerTestUtil;
    
    private CrudServiceI<E, R, ID> service;
    
    public abstract CrudServiceI<E, R, ID> getService();
    
    private String urlMappingId() {
        return getUrlMapping() + "/{id}";
    }
    
    @SuppressWarnings("unchecked")
    private Class<T> getControllerTestUtilClass() {
        return (Class<T>) ResolvableType.forClass(this.getClass())
                                        .getSuperType()
                                        .resolveGeneric(3);
    }
    
    private T newInstanceControllerTestUtil() {
        try {
            var accessibleConstructor = ReflectionUtils.accessibleConstructor(getControllerTestUtilClass(), Faker.class, Gson.class);
            
            return accessibleConstructor.newInstance(getFaker(), getGson());
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException |
                 IllegalAccessException e) {
            throw new RuntimeException("Error al crear la instancia de la clase ControllerTestUtil.");
        }
    }
    
    @BeforeEach
    public void setUp() {
        this.controllerTestUtil = newInstanceControllerTestUtil();
        this.service = getService();
    }
    
    @Test
    void testFindAllStatusIsOk() throws Exception {
        List<R> response = this.controllerTestUtil.getResponseList();
        
        when(this.service.findAll()).thenReturn(response);
        
        var requestBuilder = get(getUrlMapping()).with(jwt());
        
        getMockMvc().perform(requestBuilder)
                    .andExpect(status().isOk());
    }
    
    @Test
    void testFindByIdStatusIsOk() throws Exception {
        ID id = this.controllerTestUtil.getId();
        R response = this.controllerTestUtil.getResponse();
        
        when(this.service.findById(eq(id))).thenReturn(response);
        
        var requestBuilder = get(urlMappingId(), id).with(jwt());
        
        getMockMvc().perform(requestBuilder)
                    .andExpect(status().isOk());
    }
    
    @Test
    void testSaveStatusIsCreated() throws Exception {
        var response = this.controllerTestUtil.getResponse();
        var request = this.controllerTestUtil.getRequest();
        String requestJSON = this.controllerTestUtil.getRequestJSON();
        
        when(this.service.save(eq(request))).thenReturn(response);
        
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
        
        when(this.service.update(eq(id), eq(request))).thenReturn(response);
        
        var requestBuilder = put(urlMappingId(), id).with(jwt())
                                                    .contentType(MediaType.APPLICATION_JSON)
                                                    .content(requestJSON);
        
        getMockMvc().perform(requestBuilder)
                    .andExpect(status().isOk());
    }
    
    @Test
    void testDeleteStatusIsNoContent() throws Exception {
        ID id = this.controllerTestUtil.getId();
        
        doNothing().when(this.service)
                   .delete(eq(id));
        
        var requestBuilder = delete(urlMappingId(), id).with(jwt());
        
        getMockMvc().perform(requestBuilder)
                    .andExpect(status().isNoContent());
    }
    
}
