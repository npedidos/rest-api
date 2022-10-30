package red.softn.npedidos.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import red.softn.npedidos.request.UserRequest;
import red.softn.npedidos.request.users.UserOrdersSaveRequest;
import red.softn.npedidos.response.UserResponse;
import red.softn.npedidos.service.UserService;

import java.net.URI;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Getter
public class UserController extends CrudController<UserRequest, UserResponse, Integer> {
    
    private final UserService service;
    
    @GetMapping("/{id}/orders")
    public ResponseEntity<?> findAllOrders(@PathVariable Integer id) {
        return ResponseEntity.ok(getService().findAllOrders(id));
    }
    
    @PostMapping("/{id}/orders")
    public ResponseEntity<?> saveOrders(@PathVariable Integer id, @RequestBody UserOrdersSaveRequest request, UriComponentsBuilder uriComponentsBuilder) {
        Integer orderId = getService().saveOrders(id, request);
        URI uri = uriComponentsBuilder.path(getAppProperties().getPathPrefix())
                                      .pathSegment("orders", "{id}")
                                      .buildAndExpand(orderId)
                                      .toUri();
        
        return ResponseEntity.created(uri)
                             .build();
    }
    
}
