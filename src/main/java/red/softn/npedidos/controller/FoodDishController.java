package red.softn.npedidos.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import red.softn.npedidos.entity.FoodDish;
import red.softn.npedidos.service.FoodDishService;

@RestController
@RequestMapping("/food-dish")
@RequiredArgsConstructor
@Getter
public class FoodDishController extends CrudController<FoodDish, Integer> {
    
    private final FoodDishService service;
    
}
