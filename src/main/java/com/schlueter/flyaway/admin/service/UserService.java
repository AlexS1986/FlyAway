package com.schlueter.flyaway.admin.service;

import com.schlueter.flyaway.admin.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.transaction.annotation.Transactional;

public interface UserService  extends UserDetailsService {
    User findByUserName(String userName);

    @Transactional
    void save(User user);

    @Transactional
    void updatePasswordOfUser(User user, String password);
}
