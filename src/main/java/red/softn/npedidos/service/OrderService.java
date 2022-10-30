package red.softn.npedidos.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import red.softn.npedidos.entity.FoodDish;
import red.softn.npedidos.entity.Order;
import red.softn.npedidos.entity.User;
import red.softn.npedidos.repository.FoodDishRepository;
import red.softn.npedidos.repository.OrderRepository;
import red.softn.npedidos.request.OrderFoodDishesSaveRequest;
import red.softn.npedidos.request.OrderRequest;
import red.softn.npedidos.response.FoodDishResponse;
import red.softn.npedidos.response.OrderResponse;
import red.softn.npedidos.response.PagingAndSortingResponse;
import red.softn.npedidos.specifications.OrderFoodDishSpecifications;

import java.util.stream.Collectors;

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
    
    @Override
    public OrderResponse save(OrderRequest request) {
        var foodDishes = request.getFoodDishesId()
                                .stream()
                                .map(FoodDish::new)
                                .collect(Collectors.toSet());
        var entity = new Order(request.getDateOrder(), foodDishes, new User(request.getUserId()));
        var save = getRepository().save(entity);
        
        return getGsonUtil().convertTo(save, getResponseClass());
    }
    
    public void saveFoodDishes(Integer id, OrderFoodDishesSaveRequest request) {
        var order = getRepository().getReferenceById(id);
        var foodDishes = order.getFoodDishes();
        
        request.getFoodDishesId()
               .stream()
               .map(FoodDish::new)
               .forEach(foodDishes::add);
        
        getRepository().save(order);
    }
    
}
