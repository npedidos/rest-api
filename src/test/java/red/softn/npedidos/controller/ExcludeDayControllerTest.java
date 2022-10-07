package red.softn.npedidos.controller;

import lombok.Getter;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import red.softn.npedidos.request.ExcludeDayRequest;
import red.softn.npedidos.response.ExcludeDayResponse;
import red.softn.npedidos.service.ExcludeDayService;

@WebMvcTest(ExcludeDayController.class)
@Getter
class ExcludeDayControllerTest extends CrudControllerTest<ExcludeDayRequest, ExcludeDayResponse, Integer, ExcludeDayControllerTestUtil> {
    
    @MockBean
    private ExcludeDayService service;
    
    private final String urlMapping = "/api/exclude-day";
    
}
