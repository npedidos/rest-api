package red.softn.npedidos.controller.security;

import lombok.Getter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.security.crypto.password.PasswordEncoder;
import red.softn.npedidos.configuration.security.WebSecurityConfig;
import red.softn.npedidos.controller.AControllerTest;
import red.softn.npedidos.repository.UserRepository;
import red.softn.npedidos.service.security.AuthService;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AuthController.class)
@Import({WebSecurityConfig.class})
@Getter
class AuthControllerTest extends AControllerTest {
    
    @MockBean
    private AuthService authService;
    
    @MockBean
    private UserRepository userRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    private AuthControllerTestUtil authControllerTestUtil;
    
    private final String urlMapping = "/api/auth";
    
    @BeforeEach
    void setUp() {
        authControllerTestUtil = new AuthControllerTestUtil(this.passwordEncoder, getFaker());
    }
    
    @Test
    void testLoginStatusIsOK() throws Exception {
        var response = authControllerTestUtil.getTokenAuthenticationResponse();
        var userEntity = this.authControllerTestUtil.getUserEntity();
        var request = this.authControllerTestUtil.getUserDetails();
        String username = request.getUsername();
        
        when(this.authService.login(eq(request))).thenReturn(response);
        when(this.userRepository.findByUsername(eq(username))).thenReturn(Optional.of(userEntity));
        
        var requestBuilder = post(getUrlMapping() + "/login").with(httpBasic(username, username));
        
        getMockMvc().perform(requestBuilder)
                    .andExpect(status().isOk());
    }
    
}
