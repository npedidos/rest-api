package red.softn.npedidos.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import red.softn.npedidos.entity.FoodDish;
import red.softn.npedidos.entity.Menu;
import red.softn.npedidos.repository.FoodDishRepository;
import red.softn.npedidos.repository.MenuRepository;
import red.softn.npedidos.request.menus.MenuFoodDishesSaveRequest;
import red.softn.npedidos.request.menus.MenuRequest;
import red.softn.npedidos.response.FoodDishResponse;
import red.softn.npedidos.response.MenuResponse;
import red.softn.npedidos.response.PagingAndSortingResponse;
import red.softn.npedidos.specifications.MenuSpecifications;

import java.util.Set;

@Service
@RequiredArgsConstructor
@Getter
public class MenuService extends CrudService<MenuRequest, MenuResponse, Menu, Integer> {
    
    private final MenuRepository repository;
    
    private final FoodDishRepository foodDishRepository;
    
    public PagingAndSortingResponse<FoodDishResponse> findAllFoodDishes(Integer id) {
        Page<FoodDish> foodDishes = this.foodDishRepository.findAll(MenuSpecifications.hasMenu(id), getDataRequestScope().getPageable());
        
        return pageToResponse(foodDishes, FoodDishResponse.class);
    }
    
    public void saveFoodDishes(Integer id, MenuFoodDishesSaveRequest request) {
        Menu menu = getRepository().getReferenceById(id);
        Set<FoodDish> foodDishes = menu.getFoodDishes();
        
        request.getFoodDishes()
               .stream()
               .map(FoodDish::new)
               .forEach(foodDishes::add);
        
        getRepository().save(menu);
    }
    
}
