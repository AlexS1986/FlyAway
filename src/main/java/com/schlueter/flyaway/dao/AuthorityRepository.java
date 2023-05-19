package com.schlueter.flyaway.dao;

import com.schlueter.flyaway.entity.AuthorityHelper;
import com.schlueter.flyaway.entity.AuthorityId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface AuthorityRepository extends JpaRepository<AuthorityHelper, AuthorityId> {
    Set<AuthorityHelper> findDistinctByUsername(String username);
}
