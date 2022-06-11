package red.softn.npedidos.service.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import red.softn.npedidos.entity.User;
import red.softn.npedidos.repository.UserRepository;

import java.util.Collections;

@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    
    private final UserRepository userRepository;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.findByUsername(username)
                                       .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        
        return org.springframework.security.core.userdetails.User.builder()
                                                                 .username(user.getUsername())
                                                                 .password(user.getPassword())
                                                                 .authorities(Collections.emptyList())
                                                                 .build();
    }
    
}
