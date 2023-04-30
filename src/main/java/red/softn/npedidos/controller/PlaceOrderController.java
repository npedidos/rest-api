package red.softn.npedidos.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import red.softn.npedidos.response.placeorder.PlaceOrderResponse;
import red.softn.npedidos.service.PlaceOrderService;

@RestController
@RequestMapping("/place-order")
@RequiredArgsConstructor
@Getter
public class PlaceOrderController {
    
    private final PlaceOrderService placeOrderService;
    
    @GetMapping
    public ResponseEntity<PlaceOrderResponse> getByCurrentDate() {
        return ResponseEntity.ok(this.placeOrderService.getByCurrentDate());
    }
    
    @GetMapping("/{menuId}")
    public ResponseEntity<PlaceOrderResponse> placeOrder(@PathVariable Integer menuId) {
        return ResponseEntity.ok(this.placeOrderService.placeOrder(menuId));
    }
    
}
