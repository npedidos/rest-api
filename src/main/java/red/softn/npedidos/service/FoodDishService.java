package red.softn.npedidos.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import red.softn.npedidos.entity.FoodDish;
import red.softn.npedidos.entity.Menu;
import red.softn.npedidos.repository.FoodDishRepository;
import red.softn.npedidos.repository.MenuRepository;
import red.softn.npedidos.request.FoodDishRequest;
import red.softn.npedidos.response.FoodDishResponse;
import red.softn.npedidos.response.MenuResponse;
import red.softn.npedidos.specifications.MenuSpecifications;

import java.util.List;

@Service
@RequiredArgsConstructor
@Getter
public class FoodDishService extends CrudService<FoodDishRequest, FoodDishResponse, FoodDish, Integer> {
    
    private final FoodDishRepository repository;
    
    private final MenuRepository menuRepository;
    
    public List<MenuResponse> findAllMenus(Integer id) {
        //SELECT * FROM menus WHERE ID IN (SELECT menus_id FROM menus_has_food_dishes WHERE food_dishes_id = :id
        List<Menu> menus = this.menuRepository.findAll(MenuSpecifications.hasFoodDish(id));
        
        return getGsonUtil().convertTo(menus, MenuResponse.class);
    }
    
}
