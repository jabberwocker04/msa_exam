package com.spring_cloud.eureka.client.auth.Repository;

import com.spring_cloud.eureka.client.auth.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByUsername(String username);
}
