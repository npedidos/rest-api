package red.softn.npedidos.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import red.softn.npedidos.request.TypeDishRequest;
import red.softn.npedidos.request.typedishes.TypeDishFoodDishesSaveRequest;
import red.softn.npedidos.response.TypeDishResponse;
import red.softn.npedidos.service.TypeDishService;

@RestController
@RequestMapping("/types-dishes")
@RequiredArgsConstructor
@Getter
public class TypeDishController extends CrudController<TypeDishRequest, TypeDishResponse, Integer> {
    
    private final TypeDishService service;
    
    @GetMapping("/{id}/food-dishes")
    public ResponseEntity<?> findAllFoodDishes(@PathVariable Integer id) {
        return ResponseEntity.ok(getService().findAllFoodDishes(id));
    }
    
    @PostMapping("/{id}/food-dishes")
    public ResponseEntity<?> saveFoodDishes(@PathVariable Integer id, @RequestBody TypeDishFoodDishesSaveRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                             .body(getService().saveFoodDishes(id, request));
    }
    
}
