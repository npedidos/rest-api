package red.softn.npedidos.controller;

import lombok.Getter;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import red.softn.npedidos.CrudControllerTest;
import red.softn.npedidos.request.MenuRequest;
import red.softn.npedidos.response.MenuResponse;
import red.softn.npedidos.service.MenuService;

@WebMvcTest(MenuController.class)
@Getter
public class MenuControllerTest extends CrudControllerTest<MenuRequest, MenuResponse, Integer, MenuControllerTestUtil> {
    
    @MockBean
    private MenuService service;
    
    private final String urlMapping = "/api/menus";
    
}

