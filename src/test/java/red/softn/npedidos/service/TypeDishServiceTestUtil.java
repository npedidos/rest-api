package red.softn.npedidos.service;

import red.softn.npedidos.CrudServiceTestUtil;
import red.softn.npedidos.TestUtil;
import red.softn.npedidos.entity.TypeDish;
import red.softn.npedidos.request.typedishes.TypeDishRequest;
import red.softn.npedidos.response.TypeDishResponse;

public class TypeDishServiceTestUtil extends CrudServiceTestUtil<TypeDishRequest, TypeDishResponse, TypeDish, Integer> {
    
    public TypeDishServiceTestUtil() {
        super();
    }
    
    @Override
    public Init<TypeDishRequest, TypeDishResponse, TypeDish, Integer> init() {
        var request = new TypeDishRequest();
        var response = new TypeDishResponse();
        var entity = new TypeDish();
        var entitySaveResult = new TypeDish();
        
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
