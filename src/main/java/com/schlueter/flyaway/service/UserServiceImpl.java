package com.schlueter.flyaway.service;

import com.schlueter.flyaway.dao.AuthorityRepository;
import com.schlueter.flyaway.dao.UserRepository;
import com.schlueter.flyaway.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private AuthorityRepository authorityRepository;

    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           AuthorityRepository authorityRepository) {
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
        user.setPassword("{bcrypt}" + passwordEncoder.encode(password));
        save(user);
    }


}
