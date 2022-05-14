package red.softn.npedidos.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import red.softn.npedidos.entity.FoodDish;
import red.softn.npedidos.repository.FoodDishRepository;

@Service
@RequiredArgsConstructor
@Getter
public class FoodDishService extends CrudService<FoodDish, Integer> {
    
    private final FoodDishRepository repository;
}
