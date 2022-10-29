package red.softn.npedidos.service;

import lombok.Getter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;
import red.softn.npedidos.CrudServiceTest;
import red.softn.npedidos.entity.User;
import red.softn.npedidos.repository.UserRepository;
import red.softn.npedidos.request.users.UserRequest;
import red.softn.npedidos.response.UserResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@Getter
public class UserServiceTest extends CrudServiceTest<UserRequest, UserResponse, User, Integer, UserServiceTestUtil> {
    
    @InjectMocks
    private UserService service;
    
    @Mock
    private UserRepository repository;
    
    @Mock
    private PasswordEncoder passwordEncoder;
    
    @Test
    @Override
    public void testSave() {
        var request = getCrudServiceTestUtil().getRequest();
        var expected = getCrudServiceTestUtil().getResponse();
        var entity = getCrudServiceTestUtil().getEntity();
        var entitySaveResult = getCrudServiceTestUtil().getEntitySaveResult();
        
        when(this.passwordEncoder.encode(request.getPassword())).thenReturn(entity.getPassword());
        when(getGsonUtil().convertTo(eq(request), eq(User.class))).thenReturn(entity);
        when(getRepository().save(eq(entity))).thenReturn(entitySaveResult);
        when(getGsonUtil().convertTo(eq(entitySaveResult), eq(UserResponse.class))).thenReturn(expected);
        
        var actual = getService().save(request);
        
        assertEquals(expected, actual);
    }
    
}
