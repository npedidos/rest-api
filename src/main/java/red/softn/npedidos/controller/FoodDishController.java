package red.softn.npedidos.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import red.softn.npedidos.request.fooddish.FoodDishMenusRequest;
import red.softn.npedidos.request.fooddish.FoodDishOrdersRequest;
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
    public ResponseEntity<?> saveMenus(@PathVariable Integer id, @RequestBody FoodDishMenusRequest request) {
        getService().saveMenus(id, request);
        
        return ResponseEntity.noContent()
                             .build();
    }
    
    @DeleteMapping("/{id}/menus")
    public ResponseEntity<?> deleteMenus(@PathVariable Integer id, @RequestBody FoodDishMenusRequest request) {
        getService().deleteMenus(id, request);
        
        return ResponseEntity.noContent()
                             .build();
    }
    
    @GetMapping("/{id}/orders")
    public ResponseEntity<?> findAllOrders(@PathVariable Integer id) {
        return ResponseEntity.ok(getService().findAllOrders(id));
    }
    
    @PostMapping("/{id}/orders")
    public ResponseEntity<?> saveOrders(@PathVariable Integer id, @RequestBody FoodDishOrdersRequest request) {
        getService().saveOrders(id, request);
        
        return ResponseEntity.noContent()
                             .build();
    }
    
    @DeleteMapping("/{id}/orders")
    public ResponseEntity<?> deleteOrders(@PathVariable Integer id, @RequestBody FoodDishOrdersRequest request) {
        getService().deleteOrders(id, request);
        
        return ResponseEntity.noContent()
                             .build();
    }
    
}
