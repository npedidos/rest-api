package red.softn.npedidos.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import red.softn.npedidos.entity.TypeDish;
import red.softn.npedidos.service.TypeDishService;

@RestController
@RequestMapping("/types-dishes")
@RequiredArgsConstructor
@Getter
public class TypeDishController extends CrudController<TypeDish, Integer> {
    
    private final TypeDishService service;
    
}
