package red.softn.npedidos.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import red.softn.npedidos.entity.FoodDish;
import red.softn.npedidos.entity.Menu;
import red.softn.npedidos.repository.FoodDishRepository;
import red.softn.npedidos.repository.MenuRepository;
import red.softn.npedidos.request.menus.MenuFoodDishesRequest;
import red.softn.npedidos.request.menus.MenuRequest;
import red.softn.npedidos.response.FoodDishResponse;
import red.softn.npedidos.response.MenuResponse;
import red.softn.npedidos.response.MonthMenuResponse;
import red.softn.npedidos.response.PagingAndSortingResponse;
import red.softn.npedidos.specifications.MenuSpecifications;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

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
    
    @Override
    public MenuResponse save(MenuRequest request) {
        Set<FoodDish> foodDishes = request.getFoodDishesId()
                                          .stream()
                                          .map(FoodDish::new)
                                          .collect(Collectors.toSet());
        var menu = new Menu(request.getDate(), foodDishes);
        var save = getRepository().save(menu);
        
        return getGsonUtil().convertTo(save, getResponseClass());
    }
    
    public void saveFoodDishes(Integer id, MenuFoodDishesRequest request) {
        Menu menu = getRepository().getReferenceById(id);
        Set<FoodDish> foodDishes = menu.getFoodDishes();
        
        request.getFoodDishesId()
               .stream()
               .map(FoodDish::new)
               .forEach(foodDishes::add);
        
        getRepository().save(menu);
    }
    
    public void deleteFoodDishes(Integer id, MenuFoodDishesRequest request) {
        var menu = getRepository().getReferenceById(id);
        var foodDishes = request.getFoodDishesId()
                                .stream()
                                .map(this.foodDishRepository::getReferenceById)
                                .collect(Collectors.toSet());
        
        menu.getFoodDishes()
            .removeAll(foodDishes);
        
        getRepository().save(menu);
    }
    
    public MonthMenuResponse findAllByMonth(LocalDate month) {
        var response = new MonthMenuResponse();
        var startDate = month.with(TemporalAdjusters.firstDayOfMonth());
        var endDate = month.with(TemporalAdjusters.lastDayOfMonth());
        var monthMenu = getRepository().findAllByDateBetween(startDate, endDate);
        var menuResponse = monthMenu.orElse(Collections.emptyList())
                                    .stream()
                                    .map(value -> new MonthMenuResponse.Menu(value.getId(), value.getDate()))
                                    .toList();
        
        response.setMenus(menuResponse);
        
        return response;
    }
    
}
