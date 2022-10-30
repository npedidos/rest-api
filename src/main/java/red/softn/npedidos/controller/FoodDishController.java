package red.softn.npedidos.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import red.softn.npedidos.request.fooddish.FoodDishMenusSaveRequest;
import red.softn.npedidos.request.fooddish.FoodDishRequest;
import red.softn.npedidos.response.FoodDishResponse;
import red.softn.npedidos.service.FoodDishService;

@RestController
@RequestMapping("/food-dishes")
@RequiredArgsConstructor
@Getter
public class FoodDishController extends CrudController<FoodDishRequest, FoodDishResponse, Integer> {
    
    private final FoodDishService service;
    
    @GetMapping("/{id}/menus")
    public ResponseEntity<?> findAllMenus(@PathVariable Integer id) {
        return ResponseEntity.ok(getService().findAllMenus(id));
    }
    
    @PostMapping("/{id}/menus")
    public ResponseEntity<?> saveMenus(@PathVariable Integer id, @RequestBody FoodDishMenusSaveRequest request) {
        getService().save(id, request);
        
        return ResponseEntity.noContent()
                             .build();
    }
    
}
