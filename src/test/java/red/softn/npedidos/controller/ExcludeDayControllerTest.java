package red.softn.npedidos.controller;

import lombok.Getter;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import red.softn.npedidos.request.ExcludeDayRequest;
import red.softn.npedidos.response.ExcludeDayResponse;
import red.softn.npedidos.service.ExcludeDayService;
import red.softn.npedidos.utils.gson.GsonConfig;

@WebMvcTest(ExcludeDayController.class)
@Import({GsonConfig.class})
@Getter
class ExcludeDayControllerTest extends CrudControllerTest<ExcludeDayRequest, ExcludeDayResponse, Integer, ExcludeDayControllerTestUtil> {
    
    @MockBean
    private ExcludeDayService service;
    
    private final String urlMapping = "/api/exclude-day";
    
}
