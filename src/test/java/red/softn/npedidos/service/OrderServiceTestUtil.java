package red.softn.npedidos.service;

import red.softn.npedidos.CrudServiceTestUtil;
import red.softn.npedidos.TestUtil;
import red.softn.npedidos.entity.FoodDish;
import red.softn.npedidos.entity.Order;
import red.softn.npedidos.entity.User;
import red.softn.npedidos.request.orders.OrderRequest;
import red.softn.npedidos.response.OrderResponse;

import java.util.Set;
import java.util.stream.Collectors;

public class OrderServiceTestUtil extends CrudServiceTestUtil<OrderRequest, OrderResponse, Order, Integer> {
    
    public OrderServiceTestUtil() {
        super();
    }
    
    @Override
    public Init<OrderRequest, OrderResponse, Order, Integer> init() {
        var foodDishesId = TestUtil.fakeRandomIntegerList();
        var request = new OrderRequest();
        var response = new OrderResponse();
        var entity = new Order();
        var entitySaveResult = new Order();
        Set<FoodDish> foodDishes = foodDishesId.stream()
                                               .map(FoodDish::new)
                                               .collect(Collectors.toSet());
        var user = new User(TestUtil.fakeRandomInteger());
        
        entity.setId(TestUtil.fakeRandomInteger());
        entity.setDateOrder(TestUtil.fakeDateFutureDaysTime());
        entity.setFoodDishes(foodDishes);
        entity.setUser(user);
        entitySaveResult.setId(entity.getId());
        entitySaveResult.setDateOrder(entity.getDateOrder());
        response.setId(entity.getId());
        response.setDateOrder(entity.getDateOrder());
        request.setId(entity.getId());
        request.setDateOrder(entity.getDateOrder());
        request.setFoodDishesId(foodDishesId);
        request.setUserId(entity.getUser()
                                .getId());
        
        return Init.of(request, response, entity, entitySaveResult, entity.getId());
    }
    
}
