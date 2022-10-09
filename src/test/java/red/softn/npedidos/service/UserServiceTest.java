package red.softn.npedidos.service;

import lombok.Getter;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import red.softn.npedidos.CrudServiceTest;
import red.softn.npedidos.entity.User;
import red.softn.npedidos.repository.UserRepository;
import red.softn.npedidos.request.UserRequest;
import red.softn.npedidos.response.UserResponse;

@ExtendWith(MockitoExtension.class)
@Getter
public class UserServiceTest extends CrudServiceTest<UserRequest, UserResponse, User, Integer, UserServiceTestUtil> {
    
    @InjectMocks
    private UserService service;
    
    @Mock
    private UserRepository repository;
    
}
