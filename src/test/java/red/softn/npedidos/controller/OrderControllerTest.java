package red.softn.npedidos.controller;

import lombok.Getter;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import red.softn.npedidos.CrudControllerTest;
import red.softn.npedidos.request.OrderRequest;
import red.softn.npedidos.response.OrderResponse;
import red.softn.npedidos.service.OrderService;

@WebMvcTest(OrderController.class)
@Getter
class OrderControllerTest extends CrudControllerTest<OrderRequest, OrderResponse, Integer, OrderControllerTestUtil> {
    
    @MockBean
    private OrderService service;
    
    private final String urlMapping = "/api/orders";
    
}
