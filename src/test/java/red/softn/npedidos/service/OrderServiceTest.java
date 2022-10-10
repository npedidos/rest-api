package red.softn.npedidos.service;

import lombok.Getter;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import red.softn.npedidos.CrudServiceTest;
import red.softn.npedidos.entity.Order;
import red.softn.npedidos.repository.OrderRepository;
import red.softn.npedidos.request.OrderRequest;
import red.softn.npedidos.response.OrderResponse;

@ExtendWith(MockitoExtension.class)
@Getter
class OrderServiceTest extends CrudServiceTest<OrderRequest, OrderResponse, Order, Integer, OrderServiceTestUtil> {
    
    @InjectMocks
    private OrderService service;
    
    @Mock
    private OrderRepository repository;
    
}
