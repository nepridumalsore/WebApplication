package org.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.example.Entity.User;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findByEmail(String email);
    boolean existsByEmail(String email);
    boolean existsByUsername(String username);
}

