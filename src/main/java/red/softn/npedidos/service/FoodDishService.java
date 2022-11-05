package red.softn.npedidos.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import red.softn.npedidos.entity.FoodDish;
import red.softn.npedidos.entity.Menu;
import red.softn.npedidos.entity.Order;
import red.softn.npedidos.repository.FoodDishRepository;
import red.softn.npedidos.repository.MenuRepository;
import red.softn.npedidos.repository.OrderRepository;
import red.softn.npedidos.repository.TypeDishRepository;
import red.softn.npedidos.request.fooddish.FoodDishMenusRequest;
import red.softn.npedidos.request.fooddish.FoodDishOrdersRequest;
import red.softn.npedidos.request.fooddish.FoodDishRequest;
import red.softn.npedidos.response.FoodDishResponse;
import red.softn.npedidos.response.MenuResponse;
import red.softn.npedidos.response.OrderResponse;
import red.softn.npedidos.response.PagingAndSortingResponse;
import red.softn.npedidos.specifications.MenuSpecifications;
import red.softn.npedidos.specifications.OrderFoodDishSpecifications;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Getter
public class FoodDishService extends CrudService<FoodDishRequest, FoodDishResponse, FoodDish, Integer> {
    
    private final FoodDishRepository repository;
    
    private final MenuRepository menuRepository;
    
    private final TypeDishRepository typeDishRepository;
    
    private final OrderRepository orderRepository;
    
    public PagingAndSortingResponse<MenuResponse> findAllMenus(Integer id) {
        //SELECT * FROM menus WHERE ID IN (SELECT menus_id FROM menus_has_food_dishes WHERE food_dishes_id = :id
        Page<Menu> menus = this.menuRepository.findAll(MenuSpecifications.hasFoodDish(id), getDataRequestScope().getPageable());
        
        return pageToResponse(menus, MenuResponse.class);
    }
    
    @Override
    public FoodDishResponse save(FoodDishRequest request) {
        FoodDish foodDish = getGsonUtil().convertTo(request, getEntityClass());
        var typeDish = this.typeDishRepository.getReferenceById(request.getTypeDishId());
        
        foodDish.setTypeDish(typeDish);
        
        var save = getRepository().save(foodDish);
        
        return getGsonUtil().convertTo(save, getResponseClass());
    }
    
    public void saveMenus(Integer id, FoodDishMenusRequest request) {
        FoodDish foodDish = getRepository().getReferenceById(id);
        Set<Menu> menus = foodDish.getMenus();
        
        request.getMenusId()
               .stream()
               .map(Menu::new)
               .forEach(menus::add);
        
        getRepository().save(foodDish);
    }
    
    public void deleteMenus(Integer id, FoodDishMenusRequest request) {
        var foodDish = getRepository().getReferenceById(id);
        var menus = request.getMenusId()
                           .stream()
                           .map(this.menuRepository::getReferenceById)
                           .collect(Collectors.toSet());
        
        foodDish.getMenus()
                .removeAll(menus);
        
        getRepository().save(foodDish);
    }
    
    public PagingAndSortingResponse<OrderResponse> findAllOrders(Integer id) {
        Page<Order> orders = this.orderRepository.findAll(OrderFoodDishSpecifications.hasOrder(id), getDataRequestScope().getPageable());
        
        return pageToResponse(orders, OrderResponse.class);
    }
    
    public void saveOrders(Integer id, FoodDishOrdersRequest request) {
        var foodDish = getRepository().getReferenceById(id);
        var orders = foodDish.getOrders();
        
        request.getOrdersId()
               .stream()
               .map(Order::new)
               .forEach(orders::add);
        
        getRepository().save(foodDish);
    }
    
    public void deleteOrders(Integer id, FoodDishOrdersRequest request) {
        var foodDish = getRepository().getReferenceById(id);
        var orders = request.getOrdersId()
                            .stream()
                            .map(this.orderRepository::getReferenceById)
                            .collect(Collectors.toSet());
        
        foodDish.getOrders()
                .removeAll(orders);
        
        getRepository().save(foodDish);
    }
    
}
