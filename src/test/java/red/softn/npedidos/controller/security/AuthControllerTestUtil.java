package red.softn.npedidos.controller.security;

import com.google.gson.Gson;
import lombok.Getter;
import red.softn.npedidos.TestUtil;
import red.softn.npedidos.entity.User;
import red.softn.npedidos.request.LoginRequest;
import red.softn.npedidos.response.TokenAuthenticationResponse;

@Getter
public class AuthControllerTestUtil {
    
    private User userEntity;
    
    private TokenAuthenticationResponse tokenAuthenticationResponse;
    
    private LoginRequest loginRequest;
    
    private final String requestJSON;
    
    public AuthControllerTestUtil(Gson gson) {
        init();
        this.requestJSON = gson.toJson(this.loginRequest);
    }
    
    private void init() {
        var user = new TokenAuthenticationResponse.User();
        this.userEntity = new User();
        this.loginRequest = new LoginRequest();
        this.tokenAuthenticationResponse = new TokenAuthenticationResponse();
        
        user.setUsername(loginRequest.getUsername());
        this.userEntity.setId(TestUtil.fakeRandomInteger());
        this.userEntity.setEmail(TestUtil.fakeRandomEmail());
        this.userEntity.setUsername(TestUtil.fakeRandomUsername());
        this.userEntity.setPassword(TestUtil.fakeRandomPassword());
        this.loginRequest.setUsername(this.userEntity.getUsername());
        this.loginRequest.setPassword(this.userEntity.getPassword());
        this.tokenAuthenticationResponse.setToken(TestUtil.fakeRandomWord());
        this.tokenAuthenticationResponse.setUser(user);
    }
    
}
