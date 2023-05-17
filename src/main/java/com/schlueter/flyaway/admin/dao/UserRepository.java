package com.schlueter.flyaway.admin.dao;

import com.schlueter.flyaway.admin.entity.Airline;
import com.schlueter.flyaway.admin.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface UserRepository extends JpaRepository<User, String> {
    public User findByUsername(String username);


}
