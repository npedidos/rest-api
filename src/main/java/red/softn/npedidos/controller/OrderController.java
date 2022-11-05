package red.softn.npedidos.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import red.softn.npedidos.request.orders.OrderFoodDishesRequest;
import red.softn.npedidos.request.orders.OrderRequest;
import red.softn.npedidos.response.OrderResponse;
import red.softn.npedidos.service.OrderService;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
@Getter
public class OrderController extends CrudController<OrderRequest, OrderResponse, Integer> {
    
    private final OrderService service;
    
    @GetMapping("/{id}/food-dishes")
    public ResponseEntity<?> findAllFoodDishes(@PathVariable Integer id) {
        return ResponseEntity.ok(getService().findAllFoodDishes(id));
    }
    
    @PostMapping("/{id}/food-dishes")
    public ResponseEntity<?> saveFoodDishes(@PathVariable Integer id, @RequestBody OrderFoodDishesRequest request) {
        getService().saveFoodDishes(id, request);
        
        return ResponseEntity.noContent()
                             .build();
    }
    
    @DeleteMapping("/{id}/food-dishes")
    public ResponseEntity<?> deleteFoodDishes(@PathVariable Integer id, @RequestBody OrderFoodDishesRequest request) {
        getService().deleteFoodDishes(id, request);
        
        return ResponseEntity.noContent()
                             .build();
    }
    
}
