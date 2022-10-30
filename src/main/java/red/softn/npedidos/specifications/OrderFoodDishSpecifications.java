package red.softn.npedidos.specifications;

import org.springframework.data.jpa.domain.Specification;
import red.softn.npedidos.entity.FoodDish;
import red.softn.npedidos.entity.Order;

import javax.persistence.criteria.Join;

public class OrderFoodDishSpecifications {
    
    public static Specification<FoodDish> hasFoodDish(Integer id) {
        return (root, query, criteriaBuilder) -> {
            Join<FoodDish, Order> foodDishJoin = root.join("orders");
            
            return criteriaBuilder.equal(foodDishJoin.get("id"), id);
        };
    }
    
}
