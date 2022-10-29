package red.softn.npedidos.controller;

import com.google.gson.Gson;
import red.softn.npedidos.ControllerTestUtil;
import red.softn.npedidos.TestUtil;
import red.softn.npedidos.request.fooddish.FoodDishRequest;
import red.softn.npedidos.response.FoodDishResponse;

public class FoodDishControllerTestUtil extends ControllerTestUtil<FoodDishRequest, FoodDishResponse, Integer> {
    
    public FoodDishControllerTestUtil(Gson gson) {
        super(gson);
    }
    
    @Override
    protected Init<FoodDishRequest, FoodDishResponse, Integer> init() {
        var request = new FoodDishRequest();
        var response = new FoodDishResponse();
        
        request.setId(TestUtil.fakeRandomInteger());
        request.setName(TestUtil.fakeRandomWord());
        response.setId(request.getId());
        response.setName(request.getName());
        
        return Init.of(request, response, request.getId());
    }
    
}
