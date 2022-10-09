package red.softn.npedidos.service;

import lombok.Getter;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import red.softn.npedidos.CrudServiceTest;
import red.softn.npedidos.entity.TypeDish;
import red.softn.npedidos.repository.TypeDishRepository;
import red.softn.npedidos.request.TypeDishRequest;
import red.softn.npedidos.response.TypeDishResponse;

/**
 * @author <a href="https://github.com/anas-elgarhy">Anas Elgarhy</a>
 * @version 1.0
 * @since 09/10/2022
 */
@ExtendWith(MockitoExtension.class)
@Getter
class TypeDishServiceTest extends CrudServiceTest<TypeDishRequest, TypeDishResponse, TypeDish, Integer, TypeDishServiceTestUtil> {
    
    @InjectMocks
    private TypeDishService service;
    
    @Mock
    private TypeDishRepository repository;
    
}
