package com.coderoad.deliciousfood.repositories;

import com.coderoad.deliciousfood.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByFacebookId(String facebookId);
}