package red.softn.npedidos.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import red.softn.npedidos.entity.User;
import red.softn.npedidos.repository.UserRepository;
import red.softn.npedidos.request.UserRequest;
import red.softn.npedidos.response.UserResponse;

@Service
@RequiredArgsConstructor
@Getter
public class UserService extends CrudService<UserRequest, UserResponse, User, Integer> {
    
    private final UserRepository repository;
    
}
