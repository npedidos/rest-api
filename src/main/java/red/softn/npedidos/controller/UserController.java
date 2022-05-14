package red.softn.npedidos.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import red.softn.npedidos.entity.User;
import red.softn.npedidos.service.UserService;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Getter
public class UserController extends CrudController<User, Integer> {
    
    private final UserService service;
    
}
