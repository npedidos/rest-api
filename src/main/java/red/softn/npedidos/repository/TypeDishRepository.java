package red.softn.npedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import red.softn.npedidos.entity.TypeDish;

@Repository
public interface TypeDishRepository extends JpaRepository<TypeDish, Integer> {}
