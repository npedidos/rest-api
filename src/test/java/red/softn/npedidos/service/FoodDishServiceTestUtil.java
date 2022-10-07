package red.softn.npedidos.service;

import net.datafaker.Faker;
import red.softn.npedidos.entity.FoodDish;
import red.softn.npedidos.request.FoodDishRequest;
import red.softn.npedidos.response.FoodDishResponse;

public class FoodDishServiceTestUtil extends CrudServiceTestUtil<FoodDishRequest, FoodDishResponse, FoodDish, Integer> {
    
    public FoodDishServiceTestUtil(Faker faker) {
        super(faker);
    }
    
    @Override
    public Init<FoodDishRequest, FoodDishResponse, FoodDish, Integer> init() {
        var request = new FoodDishRequest();
        var response = new FoodDishResponse();
        var entity = new FoodDish();
        var entitySaveResult = new FoodDish();
        
        entity.setId(getRandomInteger());
        entity.setName(getRandomWord());
        entitySaveResult.setId(entity.getId());
        entitySaveResult.setName(entity.getName());
        response.setId(entity.getId());
        response.setName(entity.getName());
        request.setId(entity.getId());
        request.setName(entity.getName());
        
        return Init.of(request, response, entity, entitySaveResult, entity.getId());
    }
    
}
