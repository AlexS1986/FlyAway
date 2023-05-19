package com.schlueter.flyaway.dao;

import com.schlueter.flyaway.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    public User findByUsername(String username);


}
