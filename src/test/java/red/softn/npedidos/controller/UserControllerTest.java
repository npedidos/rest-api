package red.softn.npedidos.controller;

import lombok.Getter;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import red.softn.npedidos.CrudControllerTest;
import red.softn.npedidos.request.users.UserRequest;
import red.softn.npedidos.response.UserResponse;
import red.softn.npedidos.service.UserService;

@WebMvcTest(UserController.class)
@Getter
public class UserControllerTest extends CrudControllerTest<UserRequest, UserResponse, Integer, UserControllerTestUtil> {
    
    @MockBean
    private UserService service;
    
    private final String urlMapping = "/api/users";
    
}
