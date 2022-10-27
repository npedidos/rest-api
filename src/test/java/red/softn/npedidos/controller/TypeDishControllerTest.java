package red.softn.npedidos.controller;

import lombok.Getter;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import red.softn.npedidos.CrudControllerTest;
import red.softn.npedidos.request.TypeDishRequest;
import red.softn.npedidos.response.TypeDishResponse;
import red.softn.npedidos.service.TypeDishService;

@WebMvcTest(TypeDishController.class)
@Getter
public class TypeDishControllerTest extends CrudControllerTest<TypeDishRequest, TypeDishResponse, Integer, TypeDishControllerTestTestUtil> {
    
    @MockBean
    private TypeDishService service;
    
    private final String urlMapping = "/api/types-dishes";
    
    
}
