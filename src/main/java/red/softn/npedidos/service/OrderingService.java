package red.softn.npedidos.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import red.softn.npedidos.entity.Ordering;
import red.softn.npedidos.repository.OrderingRepository;
import red.softn.npedidos.request.OrderingRequest;
import red.softn.npedidos.response.OrderingResponse;

@Service
@RequiredArgsConstructor
@Getter
public class OrderingService extends CrudService<OrderingRequest, OrderingResponse, Ordering, Integer> {
    
    private final OrderingRepository repository;
    
}
