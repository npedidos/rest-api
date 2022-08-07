package red.softn.npedidos.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import red.softn.npedidos.entity.FoodDish;
import red.softn.npedidos.repository.FoodDishRepository;
import red.softn.npedidos.request.FoodDishRequest;
import red.softn.npedidos.response.FoodDishResponse;

@Service
@RequiredArgsConstructor
@Getter
public class FoodDishService extends CrudService<FoodDishRequest, FoodDishResponse, FoodDish, Integer> {
    
    private final FoodDishRepository repository;
    
}
