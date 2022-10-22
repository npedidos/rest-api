package red.softn.npedidos.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import red.softn.npedidos.entity.FoodDish;

@Repository
public interface FoodDishRepository extends JpaRepository<FoodDish, Integer> {
    
    @Query("SELECT f FROM FoodDish f WHERE f.typeDish.id = :id")
    Page<FoodDish> findAllByTypeDishId(Integer id, Pageable pageable);
    
}
