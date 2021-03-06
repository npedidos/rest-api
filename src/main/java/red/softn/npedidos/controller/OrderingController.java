package red.softn.npedidos.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import red.softn.npedidos.entity.Ordering;
import red.softn.npedidos.service.OrderingService;

@RestController
@RequestMapping("/ordering")
@RequiredArgsConstructor
@Getter
public class OrderingController extends CrudController<Ordering, Integer> {
    
    private final OrderingService service;
    
}
