package red.softn.npedidos.controller.security;

import lombok.AccessLevel;
import lombok.Getter;
import net.datafaker.Faker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import red.softn.npedidos.entity.User;
import red.softn.npedidos.response.TokenAuthenticationResponse;

import java.util.Collections;

@Getter
public class AuthControllerUtil {
    
    private User userEntity;
    
    private TokenAuthenticationResponse tokenAuthenticationResponse;
    
    private UserDetails userDetails;
    
    @Getter(value = AccessLevel.PRIVATE)
    private final PasswordEncoder passwordEncoder;
    
    @Getter(value = AccessLevel.PRIVATE)
    private final Faker faker;
    
    public AuthControllerUtil(PasswordEncoder passwordEncoder, Faker faker) {
        this.passwordEncoder = passwordEncoder;
        this.faker = faker;
        initLogin();
    }
    
    private void initLogin() {
        var username = this.faker.name()
                                 .username();
        var passwordEncode = this.passwordEncoder.encode(username);
        var user = new TokenAuthenticationResponse.User(username);
        this.tokenAuthenticationResponse = new TokenAuthenticationResponse(this.faker.internet()
                                                                                     .uuid(), user);
        this.userEntity = new User();
        this.userDetails = org.springframework.security.core.userdetails.User.builder()
                                                                             .username(username)
                                                                             .password(passwordEncode)
                                                                             .authorities(Collections.emptyList())
                                                                             .build();
        
        userEntity.setId(this.faker.random()
                                   .nextInt());
        userEntity.setEmail(this.faker.internet()
                                      .emailAddress());
        userEntity.setUsername(username);
        userEntity.setPassword(passwordEncode);
        userEntity.setOrders(Collections.emptyList());
    }
    
}
