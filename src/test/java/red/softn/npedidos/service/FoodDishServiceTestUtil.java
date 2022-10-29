package red.softn.npedidos.service;

import red.softn.npedidos.CrudServiceTestUtil;
import red.softn.npedidos.TestUtil;
import red.softn.npedidos.entity.FoodDish;
import red.softn.npedidos.request.fooddish.FoodDishRequest;
import red.softn.npedidos.response.FoodDishResponse;

public class FoodDishServiceTestUtil extends CrudServiceTestUtil<FoodDishRequest, FoodDishResponse, FoodDish, Integer> {
    
    public FoodDishServiceTestUtil() {
        super();
    }
    
    @Override
    public Init<FoodDishRequest, FoodDishResponse, FoodDish, Integer> init() {
        var request = new FoodDishRequest();
        var response = new FoodDishResponse();
        var entity = new FoodDish();
        var entitySaveResult = new FoodDish();
        
        entity.setId(TestUtil.fakeRandomInteger());
        entity.setName(TestUtil.fakeRandomWord());
        entitySaveResult.setId(entity.getId());
        entitySaveResult.setName(entity.getName());
        response.setId(entity.getId());
        response.setName(entity.getName());
        request.setId(entity.getId());
        request.setName(entity.getName());
        
        return Init.of(request, response, entity, entitySaveResult, entity.getId());
    }
    
}
