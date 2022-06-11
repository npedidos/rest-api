package red.softn.npedidos.service.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwsHeader;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;
import red.softn.npedidos.response.TokenAuthenticationResponse;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class AuthService {
    
    private final JwtEncoder encoder;
    
    public TokenAuthenticationResponse login(UserDetails userDetails) {
        TokenAuthenticationResponse.User user = new TokenAuthenticationResponse.User(userDetails.getUsername());
        Instant now = Instant.now();
        long expiry = 36000L;
        JwsHeader jwsHeader = JwsHeader.with(MacAlgorithm.HS256)
                                       .build();
        JwtClaimsSet claims = JwtClaimsSet.builder()
                                          .issuer("self")
                                          .issuedAt(now)
                                          .expiresAt(now.plusSeconds(expiry))
                                          .subject(userDetails.getUsername())
                                          .build();
        String tokenValue = this.encoder.encode(JwtEncoderParameters.from(jwsHeader, claims))
                                        .getTokenValue();
        
        return new TokenAuthenticationResponse(tokenValue, user);
    }
    
}
