package red.softn.npedidos.service.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwsHeader;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;
import red.softn.npedidos.configuration.AppProperties;
import red.softn.npedidos.entity.User;
import red.softn.npedidos.exception.BadRequestException;
import red.softn.npedidos.repository.UserRepository;
import red.softn.npedidos.request.LoginRequest;
import red.softn.npedidos.response.TokenAuthenticationResponse;
import red.softn.npedidos.utils.message.MessageUtil;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class AuthService {
    
    private final JwtEncoder encoder;
    
    private final UserRepository userRepository;
    
    private final AppProperties appProperties;
    
    private final PasswordEncoder passwordEncoder;
    
    private final MessageUtil messageUtil;
    
    public TokenAuthenticationResponse login(LoginRequest request) {
        User user = this.userRepository.findByUsername(request.getUsername())
                                       .filter(value -> this.passwordEncoder.matches(request.getPassword(), value.getPassword()))
                                       .orElseThrow(() -> new BadRequestException(this.messageUtil.getMessage("error.user-password-incorrect")));
        
        String tokenValue = getTokenValue(request);
        
        return new TokenAuthenticationResponse(tokenValue, new TokenAuthenticationResponse.User(user.getUsername()));
    }
    
    private String getTokenValue(LoginRequest request) {
        Instant now = Instant.now();
        JwsHeader jwsHeader = JwsHeader.with(MacAlgorithm.HS256)
                                       .build();
        JwtClaimsSet claims = JwtClaimsSet.builder()
                                          .issuer(this.appProperties.getJwtIssuer())
                                          .issuedAt(now)
                                          .expiresAt(now.plusSeconds(this.appProperties.getJwtExpiresAt()))
                                          .subject(request.getUsername())
                                          .build();
        
        return this.encoder.encode(JwtEncoderParameters.from(jwsHeader, claims))
                           .getTokenValue();
    }
    
}
