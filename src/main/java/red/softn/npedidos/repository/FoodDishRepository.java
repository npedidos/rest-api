package red.softn.npedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import red.softn.npedidos.entity.FoodDish;

import java.util.List;

@Repository
public interface FoodDishRepository extends JpaRepository<FoodDish, Integer> {
    
    @Query("SELECT f FROM FoodDish f WHERE f.typeDish.id = :id")
    List<FoodDish> findAllByTypeDishId(Integer id);
    
    @Query("SELECT f FROM FoodDish f WHERE f.id = :id AND f.typeDish.id = :typeDishId")
    FoodDish findByIdAndTypeDishId(Integer id, Integer typeDishId);
    
}
