package red.softn.npedidos.controller;

import com.google.gson.Gson;
import lombok.Getter;
import red.softn.npedidos.ControllerTestUtil;
import red.softn.npedidos.TestUtil;
import red.softn.npedidos.request.users.UserRequest;
import red.softn.npedidos.response.UserResponse;

@Getter
public class UserControllerTestUtil extends ControllerTestUtil<UserRequest, UserResponse, Integer> {
    
    public UserControllerTestUtil(Gson gson) {super(gson);}
    
    @Override
    protected Init<UserRequest, UserResponse, Integer> init() {
        var request = new UserRequest();
        var response = new UserResponse();
        
        request.setId(TestUtil.fakeRandomInteger());
        request.setEmail(TestUtil.fakeRandomEmail());
        request.setUsername(TestUtil.fakeRandomWord());
        
        response.setId(request.getId());
        response.setEmail(request.getEmail());
        response.setUsername(request.getUsername());
        
        return Init.of(request, response, request.getId());
    }
    
}
