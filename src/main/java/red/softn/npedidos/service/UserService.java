package red.softn.npedidos.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import red.softn.npedidos.entity.User;
import red.softn.npedidos.repository.UserRepository;

@Service
@RequiredArgsConstructor
@Getter
public class UserService extends CrudService<User, Integer> {
    
    private final UserRepository repository;
    
}
