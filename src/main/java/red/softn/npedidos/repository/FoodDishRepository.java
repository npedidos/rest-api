package red.softn.npedidos.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import red.softn.npedidos.entity.FoodDish;

@Repository
public interface FoodDishRepository extends CrudRepository<FoodDish, Integer> {}
