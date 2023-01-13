package com.infy.smartcontact.repository;

import com.infy.smartcontact.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    public Optional<User> findByUsername(String username);
}
