package red.softn.npedidos.service;

import red.softn.npedidos.CrudServiceTestUtil;
import red.softn.npedidos.TestUtil;
import red.softn.npedidos.entity.User;
import red.softn.npedidos.request.UserRequest;
import red.softn.npedidos.response.UserResponse;

public class UserServiceTestUtil extends CrudServiceTestUtil<UserRequest, UserResponse, User, Integer> {
    
    public UserServiceTestUtil() {
        super();
    }
    
    @Override
    public Init<UserRequest, UserResponse, User, Integer> init() {
        var request = new UserRequest();
        var response = new UserResponse();
        var entity = new User();
        var entitySaveResult = new User();
        
        entity.setId(TestUtil.fakeRandomInteger());
        entity.setUsername(TestUtil.fakeRandomWord());
        entity.setPassword(TestUtil.fakeRandomPassword());
        entity.setEmail(TestUtil.fakeRandomEmail());
        entitySaveResult.setId(entity.getId());
        entitySaveResult.setUsername(entity.getUsername());
        entitySaveResult.setPassword(entity.getPassword());
        entitySaveResult.setEmail(entity.getEmail());
        response.setId(entity.getId());
        response.setUsername(entity.getUsername());
        response.setEmail(entity.getEmail());
        request.setId(entity.getId());
        request.setUsername(entity.getUsername());
        request.setPassword(entity.getPassword());
        request.setEmail(entity.getEmail());
        
        return Init.of(request, response, entity, entitySaveResult, entity.getId());
    }
    
}
