package red.softn.npedidos.controller;

import com.google.gson.Gson;
import red.softn.npedidos.ControllerTestUtil;
import red.softn.npedidos.TestUtil;
import red.softn.npedidos.request.TypeDishRequest;
import red.softn.npedidos.response.TypeDishResponse;

public class TypeDishControllerTestTestUtil extends ControllerTestUtil<TypeDishRequest, TypeDishResponse, Integer> {
    
    public TypeDishControllerTestTestUtil(Gson gson) {
        super(gson);
    }
    
    @Override
    protected Init<TypeDishRequest, TypeDishResponse, Integer> init() {
        var request = new TypeDishRequest();
        var response = new TypeDishResponse();
        
        request.setId(TestUtil.fakeRandomInteger());
        request.setName(TestUtil.fakeRandomWord());
        response.setId(request.getId());
        response.setName(request.getName());
        
        return Init.of(request, response, request.getId());
    }
}
