package red.softn.npedidos.controller;

import lombok.Getter;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import red.softn.npedidos.CrudControllerTest;
import red.softn.npedidos.request.fooddish.FoodDishRequest;
import red.softn.npedidos.response.FoodDishResponse;
import red.softn.npedidos.service.FoodDishService;

@WebMvcTest(FoodDishController.class)
@Getter
public class FoodDishControllerTest extends CrudControllerTest<FoodDishRequest, FoodDishResponse, Integer, FoodDishControllerTestUtil> {
    
    private final String urlMapping = "/api/food-dishes";
    
    @MockBean
    private FoodDishService service;
    
}

