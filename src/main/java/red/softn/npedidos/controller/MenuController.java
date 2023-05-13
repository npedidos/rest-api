package red.softn.npedidos.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import red.softn.npedidos.request.menus.MenuFoodDishesRequest;
import red.softn.npedidos.request.menus.MenuRequest;
import red.softn.npedidos.response.MenuResponse;
import red.softn.npedidos.service.MenuService;

import java.time.LocalDate;

@RestController
@RequestMapping("/menus")
@RequiredArgsConstructor
@Getter
public class MenuController extends CrudController<MenuRequest, MenuResponse, Integer> {
    
    private final MenuService service;
    
    @GetMapping("/calendar/{month}")
    public ResponseEntity<?> findAllByMonth(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate month) {
        return ResponseEntity.ok(getService().findAllByMonth(month));
    }
    
    @GetMapping("/{id}/food-dishes")
    public ResponseEntity<?> findAllFoodDishes(@PathVariable Integer id) {
        return ResponseEntity.ok(getService().findAllFoodDishes(id));
    }
    
    @PostMapping("/{id}/food-dishes")
    public ResponseEntity<?> saveFoodDishes(@PathVariable Integer id, @RequestBody MenuFoodDishesRequest request) {
        getService().saveFoodDishes(id, request);
        
        return ResponseEntity.noContent()
                             .build();
    }
    
    @DeleteMapping("/{id}/food-dishes")
    public ResponseEntity<?> deleteFoodDishes(@PathVariable Integer id, @RequestBody MenuFoodDishesRequest request) {
        getService().deleteFoodDishes(id, request);
        
        return ResponseEntity.noContent()
                             .build();
    }
    
}
