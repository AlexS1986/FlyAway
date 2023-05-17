package com.schlueter.flyaway.admin.service;

import com.schlueter.flyaway.admin.dao.AuthorityHelperRepository;
import com.schlueter.flyaway.admin.dao.UserRepository;
import com.schlueter.flyaway.admin.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private AuthorityHelperRepository authorityRepository;

    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           //BCryptPasswordEncoder passwordEncoder,
                           AuthorityHelperRepository authorityRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
        this.authorityRepository = authorityRepository;
    }
    @Override
    public User findByUserName(String userName) {
        return userRepository.findById(userName).orElseThrow(() -> new RuntimeException("User not found - " + userName));
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void updatePasswordOfUser(User user, String password) {
        user.setPassword(passwordEncoder.encode(password));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found - " + username);
        }
        // Build the UserDetails object
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .roles(authorityRepository
                        .findDistinctByUsername(username)
                        .toArray(new String[0]))
                .build();
    }
}
