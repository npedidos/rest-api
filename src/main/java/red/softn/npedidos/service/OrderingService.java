package red.softn.npedidos.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import red.softn.npedidos.entity.Ordering;
import red.softn.npedidos.repository.OrderingRepository;

@Service
@RequiredArgsConstructor
@Getter
public class OrderingService extends CrudService<Ordering, Integer> {
    
    private final OrderingRepository repository;
    
}
