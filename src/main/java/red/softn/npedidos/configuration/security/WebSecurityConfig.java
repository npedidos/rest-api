package red.softn.npedidos.configuration.security;

import com.nimbusds.jose.KeyLengthException;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.jwk.source.ImmutableSecret;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.web.SecurityFilterChain;
import red.softn.npedidos.configuration.AppProperties;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {
    
    private final AppProperties appProperties;
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.antMatcher(appProperties.getPathPrefix() + "/**")
            .authorizeRequests(authorizeRequestCustomizer -> {
                if (ArrayUtils.isNotEmpty(appProperties.getPermitAllPaths())) {
                    authorizeRequestCustomizer.antMatchers(appProperties.getPermitAllPaths())
                                              .permitAll();
                }
            
                authorizeRequestCustomizer.anyRequest()
                                          .authenticated();
            })
            .httpBasic(AbstractHttpConfigurer::disable)
            .csrf(AbstractHttpConfigurer::disable)
            .sessionManagement(sessionManagerCustomizer -> sessionManagerCustomizer.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
        
        return http.build();
    }
    
    @Bean
    public PasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public JwtEncoder jwtEncoder() throws KeyLengthException {
        MACSigner macSigner = new MACSigner(appProperties.getSecretKey());
        JWKSource<SecurityContext> jwkSource = new ImmutableSecret<>(macSigner.getSecretKey());
        
        return new NimbusJwtEncoder(jwkSource);
    }
    
    @Bean
    public JwtDecoder jwtDecoder() throws KeyLengthException {
        MACSigner macSigner = new MACSigner(appProperties.getSecretKey());
        
        return NimbusJwtDecoder.withSecretKey(macSigner.getSecretKey())
                               .macAlgorithm(MacAlgorithm.HS256)
                               .build();
    }
    
}
