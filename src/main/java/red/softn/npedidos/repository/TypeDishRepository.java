package red.softn.npedidos.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import red.softn.npedidos.entity.TypeDish;

@Repository
public interface TypeDishRepository extends CrudRepository<TypeDish, Integer> {}
