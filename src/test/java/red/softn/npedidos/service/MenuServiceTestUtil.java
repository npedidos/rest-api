package red.softn.npedidos.service;

import red.softn.npedidos.CrudServiceTestUtil;
import red.softn.npedidos.TestUtil;
import red.softn.npedidos.entity.FoodDish;
import red.softn.npedidos.entity.Menu;
import red.softn.npedidos.request.menus.MenuRequest;
import red.softn.npedidos.response.MenuResponse;

import java.util.stream.Collectors;

class MenuServiceTestUtil extends CrudServiceTestUtil<MenuRequest, MenuResponse, Menu, Integer> {
    
    public MenuServiceTestUtil() {
        super();
    }
    
    @Override
    public Init<MenuRequest, MenuResponse, Menu, Integer> init() {
        var request = new MenuRequest();
        var response = new MenuResponse();
        var entity = new Menu();
        var entitySaveResult = new Menu();
        var foodDishesId = TestUtil.fakeRandomIntegerList();
        var foodDishes = foodDishesId.stream()
                                     .map(this::getFoodDish)
                                     .collect(Collectors.toSet());
        
        entity.setId(TestUtil.fakeRandomInteger());
        entity.setDate(TestUtil.fakeDateFutureDays());
        entity.setFoodDishes(foodDishes);
        entitySaveResult.setId(entity.getId());
        entitySaveResult.setDate(entity.getDate());
        response.setId(entity.getId());
        response.setDate(entity.getDate());
        request.setId(entity.getId());
        request.setDate(entity.getDate());
        request.setFoodDishesId(foodDishesId);
        
        return Init.of(request, response, entity, entitySaveResult, entity.getId());
    }
    
    private FoodDish getFoodDish(Integer value) {
        FoodDish foodDish = new FoodDish();
        
        foodDish.setId(value);
        foodDish.setName(TestUtil.fakeRandomWord());
        
        return foodDish;
    }
    
}
