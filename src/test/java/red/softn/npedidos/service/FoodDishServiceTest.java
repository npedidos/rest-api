package red.softn.npedidos.service;

import lombok.Getter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import red.softn.npedidos.CrudServiceTest;
import red.softn.npedidos.entity.FoodDish;
import red.softn.npedidos.repository.FoodDishRepository;
import red.softn.npedidos.repository.TypeDishRepository;
import red.softn.npedidos.request.fooddish.FoodDishRequest;
import red.softn.npedidos.response.FoodDishResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@Getter
class FoodDishServiceTest extends CrudServiceTest<FoodDishRequest, FoodDishResponse, FoodDish, Integer, FoodDishServiceTestUtil> {
    
    @InjectMocks
    private FoodDishService service;
    
    @Mock
    private TypeDishRepository typeDishRepository;
    
    @Mock
    private FoodDishRepository repository;
    
    @Test
    @Override
    public void testSave() {
        var request = getCrudServiceTestUtil().getRequest();
        var expected = getCrudServiceTestUtil().getResponse();
        var entity = getCrudServiceTestUtil().getEntity();
        var entitySaveResult = getCrudServiceTestUtil().getEntitySaveResult();
        
        when(getGsonUtil().convertTo(eq(request), eq(FoodDish.class))).thenReturn(entity);
        when(this.typeDishRepository.getReferenceById(eq(request.getTypeDishId()))).thenReturn(entity.getTypeDish());
        when(getRepository().save(eq(entity))).thenReturn(entitySaveResult);
        when(getGsonUtil().convertTo(eq(entitySaveResult), eq(FoodDishResponse.class))).thenReturn(expected);
        
        var actual = getService().save(request);
        
        assertEquals(expected, actual);
    }
    
}
