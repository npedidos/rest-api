package red.softn.npedidos.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import red.softn.npedidos.request.FoodDishRequest;
import red.softn.npedidos.request.TypeDishRequest;
import red.softn.npedidos.response.FoodDishResponse;
import red.softn.npedidos.response.TypeDishResponse;
import red.softn.npedidos.service.TypeDishService;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;

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
    
    @GetMapping("/{id}/food-dishes/{foodDishId}")
    public ResponseEntity<?> findByIdFoodDish(@PathVariable Integer id, @PathVariable Integer foodDishId) {
        return ResponseEntity.ok(getService().findByIdFoodDish(id, foodDishId));
    }
    
    @PostMapping("/{id}/food-dishes")
    public ResponseEntity<?> save(@PathVariable Integer id, @RequestBody FoodDishRequest request, UriComponentsBuilder uriComponentsBuilder, HttpServletRequest httpServletRequest) {
        FoodDishResponse response = getService().save(id, request);
        URI uri = uriComponentsBuilder.path(httpServletRequest.getServletPath())
                                      .pathSegment("{foodDish}")
                                      .buildAndExpand(response.getId())
                                      .toUri();
        
        return ResponseEntity.created(uri)
                             .body(response);
    }
    
}
