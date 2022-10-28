package red.softn.npedidos.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import red.softn.npedidos.entity.FoodDish;
import red.softn.npedidos.entity.Order;
import red.softn.npedidos.repository.FoodDishRepository;
import red.softn.npedidos.repository.OrderRepository;
import red.softn.npedidos.request.OrderRequest;
import red.softn.npedidos.response.FoodDishResponse;
import red.softn.npedidos.response.OrderResponse;
import red.softn.npedidos.response.PagingAndSortingResponse;
import red.softn.npedidos.specifications.OrderFoodDishSpecifications;

@Service
@RequiredArgsConstructor
@Getter
public class OrderService extends CrudService<OrderRequest, OrderResponse, Order, Integer> {
    
    private final OrderRepository repository;
    
    private final FoodDishRepository foodDishRepository;
    
    public PagingAndSortingResponse<FoodDishResponse> findAllFoodDishes(Integer id) {
        Page<FoodDish> foodDishes = this.foodDishRepository.findAll(OrderFoodDishSpecifications.hasFoodDish(id), getDataRequestScope().getPageable());
        
        return pageToResponse(foodDishes, FoodDishResponse.class);
    }
    
}
