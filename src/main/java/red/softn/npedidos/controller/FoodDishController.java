package red.softn.npedidos.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import red.softn.npedidos.request.FoodDishRequest;
import red.softn.npedidos.request.MenuRequest;
import red.softn.npedidos.response.FoodDishResponse;
import red.softn.npedidos.response.MenuResponse;
import red.softn.npedidos.service.FoodDishService;

import java.net.URI;

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
    public ResponseEntity<?> saveMenus(@PathVariable Integer id, @RequestBody MenuRequest request, UriComponentsBuilder uriComponentsBuilder) {
        MenuResponse response = getService().save(id, request);
        URI uri = uriComponentsBuilder.path(getAppProperties().getPathPrefix())
                                      .pathSegment("menus", "{id}")
                                      .buildAndExpand(response.getId())
                                      .toUri();
        
        return ResponseEntity.created(uri)
                             .body(response);
    }
    
}
