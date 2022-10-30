package red.softn.npedidos.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import red.softn.npedidos.entity.FoodDish;
import red.softn.npedidos.entity.Menu;
import red.softn.npedidos.repository.FoodDishRepository;
import red.softn.npedidos.repository.MenuRepository;
import red.softn.npedidos.request.fooddish.FoodDishMenusSaveRequest;
import red.softn.npedidos.request.fooddish.FoodDishRequest;
import red.softn.npedidos.response.FoodDishResponse;
import red.softn.npedidos.response.MenuResponse;
import red.softn.npedidos.response.PagingAndSortingResponse;
import red.softn.npedidos.specifications.MenuSpecifications;

import java.util.Set;

@Service
@RequiredArgsConstructor
@Getter
public class FoodDishService extends CrudService<FoodDishRequest, FoodDishResponse, FoodDish, Integer> {
    
    private final FoodDishRepository repository;
    
    private final MenuRepository menuRepository;
    
    public PagingAndSortingResponse<MenuResponse> findAllMenus(Integer id) {
        //SELECT * FROM menus WHERE ID IN (SELECT menus_id FROM menus_has_food_dishes WHERE food_dishes_id = :id
        Page<Menu> menus = this.menuRepository.findAll(MenuSpecifications.hasFoodDish(id), getDataRequestScope().getPageable());
        
        return pageToResponse(menus, MenuResponse.class);
    }
    
    public void save(Integer id, FoodDishMenusSaveRequest request) {
        FoodDish foodDish = getRepository().getReferenceById(id);
        Set<Menu> menus = foodDish.getMenus();
        
        request.getMenus()
               .stream()
               .map(Menu::new)
               .forEach(menus::add);
        
        getRepository().save(foodDish);
    }
    
}
