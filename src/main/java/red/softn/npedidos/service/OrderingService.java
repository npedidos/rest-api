package red.softn.npedidos.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import red.softn.npedidos.entity.Order;
import red.softn.npedidos.repository.OrderRepository;
import red.softn.npedidos.request.OrderRequest;
import red.softn.npedidos.response.OrderResponse;

@Service
@RequiredArgsConstructor
@Getter
public class OrderingService extends CrudService<OrderRequest, OrderResponse, Order, Integer> {
    
    private final OrderRepository repository;
    
}
