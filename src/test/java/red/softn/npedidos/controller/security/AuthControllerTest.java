package red.softn.npedidos.controller.security;

import com.google.gson.Gson;
import lombok.Getter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import red.softn.npedidos.ControllerTest;
import red.softn.npedidos.configuration.security.WebSecurityConfig;
import red.softn.npedidos.service.security.AuthService;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AuthController.class)
@Import({WebSecurityConfig.class})
@Getter
class AuthControllerTest extends ControllerTest {
    
    @MockBean
    private AuthService authService;
    
    @Autowired
    private Gson gson;
    
    private AuthControllerTestUtil authControllerTestUtil;
    
    private final String urlMapping = "/api/auth";
    
    @BeforeEach
    void setUp() {
        authControllerTestUtil = new AuthControllerTestUtil(getGson());
    }
    
    @Test
    void testLoginStatusIsOK() throws Exception {
        var response = this.authControllerTestUtil.getTokenAuthenticationResponse();
        var request = this.authControllerTestUtil.getLoginRequest();
        var requestJSON = this.authControllerTestUtil.getRequestJSON();
        
        when(this.authService.login(eq(request))).thenReturn(response);
        
        var requestBuilder = post(getUrlMapping("/login")).contentType(MediaType.APPLICATION_JSON)
                                                          .content(requestJSON);
        
        getMockMvc().perform(requestBuilder)
                    .andExpect(status().isOk());
    }
    
}
