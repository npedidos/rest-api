package red.softn.npedidos.service;

import lombok.Getter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import red.softn.npedidos.CrudServiceTest;
import red.softn.npedidos.entity.Order;
import red.softn.npedidos.repository.OrderRepository;
import red.softn.npedidos.request.OrderRequest;
import red.softn.npedidos.response.OrderResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@Getter
class OrderServiceTest extends CrudServiceTest<OrderRequest, OrderResponse, Order, Integer, OrderServiceTestUtil> {
    
    @InjectMocks
    private OrderService service;
    
    @Mock
    private OrderRepository repository;
    
    @Test
    @Override
    public void testSave() {
        var request = getCrudServiceTestUtil().getRequest();
        var expected = getCrudServiceTestUtil().getResponse();
        var entity = getCrudServiceTestUtil().getEntity();
        var entitySaveResult = getCrudServiceTestUtil().getEntitySaveResult();
        
        entity.setId(null);
        
        when(getRepository().save(eq(entity))).thenReturn(entitySaveResult);
        when(getGsonUtil().convertTo(eq(entitySaveResult), eq(OrderResponse.class))).thenReturn(expected);
        
        var actual = getService().save(request);
        
        assertEquals(expected, actual);
    }
    
}
