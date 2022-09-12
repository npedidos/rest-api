package red.softn.npedidos.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import red.softn.npedidos.request.OrderRequest;
import red.softn.npedidos.response.OrderResponse;
import red.softn.npedidos.service.OrderingService;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
@Getter
public class OrderController extends CrudController<OrderRequest, OrderResponse, Integer> {
    
    private final OrderingService service;
    
}
