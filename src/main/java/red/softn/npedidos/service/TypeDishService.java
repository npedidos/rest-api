package red.softn.npedidos.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import red.softn.npedidos.entity.TypeDish;
import red.softn.npedidos.repository.TypeDishRepository;

@Service
@RequiredArgsConstructor
@Getter
public class TypeDishService extends CrudService<TypeDish, Integer> {
    
    private final TypeDishRepository repository;
    
}
