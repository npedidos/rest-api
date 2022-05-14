package red.softn.npedidos.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import red.softn.npedidos.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {}
