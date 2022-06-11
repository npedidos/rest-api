package red.softn.npedidos.configuration.security;

import com.nimbusds.jose.KeyLengthException;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.jwk.source.ImmutableSecret;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.web.SecurityFilterChain;
import red.softn.npedidos.repository.UserRepository;
import red.softn.npedidos.service.security.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {
    
    @Value("${app.http.path.prefix:}")
    private String pathPrefix;
    
    @Value("${app.http.paths.permit-all:}")
    private String[] permitAllPaths;
    
    @Value("${app.security.jwt.secret}")
    private String secretKey;
    
    private final UserRepository userRepository;
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.antMatcher(pathPrefix + "/**")
            .authorizeRequests(authorizeRequestCustomizer -> {
                if (ArrayUtils.isNotEmpty(permitAllPaths)) {
                    authorizeRequestCustomizer.antMatchers(permitAllPaths)
                                              .permitAll();
                }
            
                authorizeRequestCustomizer.anyRequest()
                                          .authenticated();
            })
            .httpBasic(Customizer.withDefaults())
            .authenticationProvider(daoAuthenticationProvider())
            .csrf(AbstractHttpConfigurer::disable)
            .sessionManagement(sessionManagerCustomizer -> sessionManagerCustomizer.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
        
        return http.build();
    }
    
    @Bean
    public UserDetailsService userDetailsServiceImpl() {
        return new UserDetailsServiceImpl(this.userRepository);
    }
    
    @Bean
    public PasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        
        daoAuthenticationProvider.setUserDetailsService(userDetailsServiceImpl());
        daoAuthenticationProvider.setPasswordEncoder(bCryptPasswordEncoder());
        
        return daoAuthenticationProvider;
    }
    
    @Bean
    public JwtEncoder jwtEncoder() throws KeyLengthException {
        MACSigner macSigner = new MACSigner(secretKey);
        JWKSource<SecurityContext> jwkSource = new ImmutableSecret<>(macSigner.getSecretKey());
        
        return new NimbusJwtEncoder(jwkSource);
    }
    
    @Bean
    public JwtDecoder jwtDecoder() throws KeyLengthException {
        MACSigner macSigner = new MACSigner(secretKey);
        
        return NimbusJwtDecoder.withSecretKey(macSigner.getSecretKey())
                               .macAlgorithm(MacAlgorithm.HS256)
                               .build();
    }
    
}
