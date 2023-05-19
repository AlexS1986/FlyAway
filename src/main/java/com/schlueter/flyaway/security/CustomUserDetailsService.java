package com.schlueter.flyaway.security;

import com.schlueter.flyaway.dao.AuthorityRepository;
import com.schlueter.flyaway.dao.UserRepository;
import com.schlueter.flyaway.entity.AuthorityHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {


    private UserRepository userRepository;

    private AuthorityRepository authorityRepository;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepository,
                                    AuthorityRepository authorityRepository) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.schlueter.flyaway.entity.User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found - " + username);
        }

        // retrieve and format roles, need to be returned without prefix
        Set<AuthorityHelper> authorities = authorityRepository.findDistinctByUsername(username);
        List<String> roles= authorities.stream().map(authority -> authority.getAuthority().replaceFirst("^ROLE_", "")).collect(Collectors.toList());
        String[] rolesArray = roles.toArray(new String[0]);

        // format password, needs to be returned without prefix
        String password = user.getPassword().replaceFirst("\\{bcrypt\\}", "");

        // build the UserDetails object
        return User.builder()
                .username(user.getUsername())
                .password(password)
                .roles(rolesArray)
                .build();
    }
}

