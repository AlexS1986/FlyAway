package com.schlueter.flyaway.service;

import com.schlueter.flyaway.entity.User;
import org.springframework.transaction.annotation.Transactional;

public interface UserService   {
    User findByUserName(String userName);

    @Transactional
    void save(User user);

    @Transactional
    void updatePasswordOfUser(User user, String password);
}
