package red.softn.npedidos.controller.security;

import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import red.softn.npedidos.TestUtil;
import red.softn.npedidos.entity.User;
import red.softn.npedidos.response.TokenAuthenticationResponse;

import java.util.Collections;

@Getter
public class AuthControllerTestUtil extends TestUtil {
    
    private User userEntity;
    
    private TokenAuthenticationResponse tokenAuthenticationResponse;
    
    private UserDetails userDetails;
    
    @Getter(value = AccessLevel.PRIVATE)
    private final PasswordEncoder passwordEncoder;
    
    public AuthControllerTestUtil(PasswordEncoder passwordEncoder) {
        super();
        this.passwordEncoder = passwordEncoder;
        initLogin();
    }
    
    private void initLogin() {
        var username = getFaker().name()
                                 .username();
        var passwordEncode = this.passwordEncoder.encode(username);
        var user = new TokenAuthenticationResponse.User(username);
        this.tokenAuthenticationResponse = new TokenAuthenticationResponse(getFaker().internet()
                                                                                     .uuid(), user);
        this.userEntity = new User();
        this.userDetails = org.springframework.security.core.userdetails.User.builder()
                                                                             .username(username)
                                                                             .password(passwordEncode)
                                                                             .authorities(Collections.emptyList())
                                                                             .build();
        
        userEntity.setId(fakeRandomInteger());
        userEntity.setEmail(getFaker().internet()
                                      .emailAddress());
        userEntity.setUsername(username);
        userEntity.setPassword(passwordEncode);
        userEntity.setOrders(Collections.emptyList());
    }
    
}
