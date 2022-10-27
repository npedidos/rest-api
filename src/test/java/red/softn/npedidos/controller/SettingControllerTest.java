package red.softn.npedidos.controller;

import lombok.Getter;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import red.softn.npedidos.CrudControllerTest;
import red.softn.npedidos.request.SettingRequest;
import red.softn.npedidos.response.SettingResponse;
import red.softn.npedidos.service.SettingService;


@WebMvcTest(SettingController.class)
@Getter
public class SettingControllerTest extends CrudControllerTest<SettingRequest, SettingResponse, Integer, SettingControllerTestUtil> {
    
    @MockBean
    private SettingService service;
    
    private final String urlMapping = "/api/settings";
    
}
