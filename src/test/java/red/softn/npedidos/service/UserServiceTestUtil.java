package red.softn.npedidos.service;

import net.datafaker.Faker;
import red.softn.npedidos.CrudServiceTestUtil;
import red.softn.npedidos.entity.User;
import red.softn.npedidos.request.UserRequest;
import red.softn.npedidos.response.UserResponse;

public class UserServiceTestUtil extends CrudServiceTestUtil<UserRequest, UserResponse, User, Integer> {
    
    public UserServiceTestUtil(Faker faker) {
        super(faker);
    }
    
    @Override
    public Init<UserRequest, UserResponse, User, Integer> init() {
        var request = new UserRequest();
        var response = new UserResponse();
        var entity = new User();
        var entitySaveResult = new User();
        
        entity.setId(fakeRandomInteger());
        entity.setUsername(fakeRandomWord());
        entitySaveResult.setId(entity.getId());
        entitySaveResult.setUsername(entity.getUsername());
        response.setId(entity.getId());
        response.setUsername(entity.getUsername());
        request.setId(entity.getId());
        request.setUsername(entity.getUsername());
        
        return Init.of(request, response, entity, entitySaveResult, entity.getId());
    }
    
}
