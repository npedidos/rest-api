package red.softn.npedidos.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import red.softn.npedidos.request.FoodDishRequest;
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
    
}
