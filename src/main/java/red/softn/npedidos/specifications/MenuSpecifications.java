package red.softn.npedidos.specifications;

import jakarta.persistence.criteria.Join;
import org.springframework.data.jpa.domain.Specification;
import red.softn.npedidos.entity.FoodDish;
import red.softn.npedidos.entity.Menu;

public class MenuSpecifications {
    
    public static Specification<Menu> hasFoodDish(Integer id) {
        return (root, query, criteriaBuilder) -> {
            Join<Menu, FoodDish> foodDishMenuJoin = root.join("foodDishes");
            
            return criteriaBuilder.equal(foodDishMenuJoin.get("id"), id);
        };
    }
    
    public static Specification<FoodDish> hasMenu(Integer id) {
        return (root, query, criteriaBuilder) -> {
            Join<FoodDish, Menu> menuJoin = root.join("menus");
            
            return criteriaBuilder.equal(menuJoin.get("id"), id);
        };
    }
    
}
