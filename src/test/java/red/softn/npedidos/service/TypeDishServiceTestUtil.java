package red.softn.npedidos.service;

import net.datafaker.Faker;
import red.softn.npedidos.CrudServiceTestUtil;
import red.softn.npedidos.entity.TypeDish;
import red.softn.npedidos.request.TypeDishRequest;
import red.softn.npedidos.response.TypeDishResponse;

/**
 * @author <a href="https://github.com/anas-elgarhy">Anas Elgarhy</a>
 * @version 1.0
 * @since 09/10/2022
 */
public class TypeDishServiceTestUtil extends CrudServiceTestUtil<TypeDishRequest, TypeDishResponse, TypeDish, Integer> {
    
    public TypeDishServiceTestUtil(Faker faker) {
        super(faker);
    }
    
    @Override
    public Init<TypeDishRequest, TypeDishResponse, TypeDish, Integer> init() {
        var request = new TypeDishRequest();
        var response = new TypeDishResponse();
        var entity = new TypeDish();
        var entitySaveResult = new TypeDish();
        
        entity.setId(fakeRandomInteger());
        entity.setName(fakeRandomWord());
        entitySaveResult.setId(entity.getId());
        entitySaveResult.setName(entity.getName());
        response.setId(entity.getId());
        response.setName(entity.getName());
        request.setId(entity.getId());
        request.setName(entity.getName());
        
        return Init.of(request, response, entity, entitySaveResult, entity.getId());
    }
    
}
