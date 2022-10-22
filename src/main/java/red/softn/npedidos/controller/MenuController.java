package red.softn.npedidos.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import red.softn.npedidos.request.MenuRequest;
import red.softn.npedidos.response.MenuResponse;
import red.softn.npedidos.service.MenuService;

@RestController
@RequestMapping("/menus")
@RequiredArgsConstructor
@Getter
public class MenuController extends CrudController<MenuRequest, MenuResponse, Integer> {
    
    private final MenuService service;
    
    @GetMapping("/{id}/food-dishes")
    public ResponseEntity<?> findAllFoodDishes(@PathVariable Integer id) {
        return ResponseEntity.ok(getService().findAllFoodDishes(id));
    }
    
}
