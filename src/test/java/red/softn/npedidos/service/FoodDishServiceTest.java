package red.softn.npedidos.service;

import lombok.Getter;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import red.softn.npedidos.entity.FoodDish;
import red.softn.npedidos.repository.FoodDishRepository;
import red.softn.npedidos.request.FoodDishRequest;
import red.softn.npedidos.response.FoodDishResponse;

@ExtendWith(MockitoExtension.class)
@Getter
class FoodDishServiceTest extends CrudServiceTest<FoodDishRequest, FoodDishResponse, FoodDish, Integer, FoodDishServiceTestUtil> {
    
    @InjectMocks
    private FoodDishService service;
    
    @Mock
    private FoodDishRepository repository;
    
}
