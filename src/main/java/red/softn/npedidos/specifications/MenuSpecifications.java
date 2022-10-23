package red.softn.npedidos.specifications;

import org.springframework.data.jpa.domain.Specification;
import red.softn.npedidos.entity.FoodDish;
import red.softn.npedidos.entity.Menu;

import javax.persistence.criteria.Join;

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
