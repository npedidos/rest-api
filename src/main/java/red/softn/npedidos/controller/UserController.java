package red.softn.npedidos.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import red.softn.npedidos.request.UserRequest;
import red.softn.npedidos.response.UserResponse;
import red.softn.npedidos.service.UserService;

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
    
}
