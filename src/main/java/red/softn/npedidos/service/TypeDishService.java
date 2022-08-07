package red.softn.npedidos.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import red.softn.npedidos.entity.TypeDish;
import red.softn.npedidos.repository.TypeDishRepository;
import red.softn.npedidos.request.TypeDishRequest;
import red.softn.npedidos.response.TypeDishResponse;

@Service
@RequiredArgsConstructor
@Getter
public class TypeDishService extends CrudService<TypeDishRequest, TypeDishResponse, TypeDish, Integer> {
    
    private final TypeDishRepository repository;
    
}
