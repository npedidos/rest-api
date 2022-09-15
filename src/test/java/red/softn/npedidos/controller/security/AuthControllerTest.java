package red.softn.npedidos.controller.security;

import net.datafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import red.softn.npedidos.repository.UserRepository;
import red.softn.npedidos.service.security.AuthService;
import red.softn.npedidos.utils.gson.GsonUtil;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AuthController.class)
    //@Import({WebSecurityConfig.class})
class AuthControllerTest {
    
    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    private AuthService authService;
    
    @MockBean
    private GsonUtil gsonUtil;
    
    @MockBean
    private UserRepository userRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private Faker faker;
    
    private AuthControllerTestUtil authControllerTestUtil;
    
    @BeforeEach
    void setUp() {
        authControllerTestUtil = new AuthControllerTestUtil(this.passwordEncoder, this.faker);
    }
    
    @Test
    void testLoginStatusIsOK() throws Exception {
        var response = authControllerTestUtil.getTokenAuthenticationResponse();
        var userEntity = this.authControllerTestUtil.getUserEntity();
        var request = this.authControllerTestUtil.getUserDetails();
        String username = request.getUsername();
        
        when(this.authService.login(request)).thenReturn(response);
        when(this.userRepository.findByUsername(eq(username))).thenReturn(Optional.of(userEntity));
        
        var requestBuilder = post("/api/auth/login").with(httpBasic(username, username));
        
        this.mockMvc.perform(requestBuilder)
                    .andExpect(status().isOk());
    }
    
}
