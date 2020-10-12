package pl.coderslab.charity.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import pl.coderslab.charity.entity.CurrentUser;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.repository.UserRepository;

import java.util.HashSet;
import java.util.Set;

public class SpringDataUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String email) {
        User user = userRepository.findByEmail(email);
        if (user == null) {throw new UsernameNotFoundException(email); }
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        user.getRole().forEach(r ->
                grantedAuthorities.add(new SimpleGrantedAuthority(r.getRole())));
        return new CurrentUser(
                user.getEmail(), user.getPassword(), user.getId(), grantedAuthorities);
    }
    //  SecurityContextHolder.getContext().getAuthentication().getPrincipal();
}