package red.softn.npedidos.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import red.softn.npedidos.request.OrderRequest;
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
    
}
