package red.softn.npedidos.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import red.softn.npedidos.entity.FoodDish;
import red.softn.npedidos.entity.Order;
import red.softn.npedidos.entity.User;
import red.softn.npedidos.repository.OrderRepository;
import red.softn.npedidos.repository.UserRepository;
import red.softn.npedidos.request.UserRequest;
import red.softn.npedidos.request.users.UserOrdersSaveRequest;
import red.softn.npedidos.response.OrderResponse;
import red.softn.npedidos.response.PagingAndSortingResponse;
import red.softn.npedidos.response.UserResponse;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Getter
public class UserService extends CrudService<UserRequest, UserResponse, User, Integer> {
    
    private final UserRepository repository;
    
    private final OrderRepository orderRepository;
    
    private final PasswordEncoder passwordEncoder;
    
    public PagingAndSortingResponse<OrderResponse> findAllOrders(Integer id) {
        Page<Order> allByUser = this.orderRepository.findAllByUserId(id, getDataRequestScope().getPageable());
        
        return pageToResponse(allByUser, OrderResponse.class);
    }
    
    @Override
    public UserResponse save(UserRequest request) {
        request.setPassword(this.passwordEncoder.encode(request.getPassword()));
        
        return super.save(request);
    }
    
    public Integer saveOrders(Integer id, UserOrdersSaveRequest request) {
        var user = getRepository().getReferenceById(id);
        var foodDishes = request.getFoodDishesId()
                                .stream()
                                .map(FoodDish::new)
                                .collect(Collectors.toSet());
        var orders = new Order(request.getDateOrder(), foodDishes, user);
        Order order = this.orderRepository.save(orders);
        
        return order.getId();
    }
    
}
