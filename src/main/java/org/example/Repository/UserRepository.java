package org.example.Repository;

import org.example.Repository.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.example.Entity.User;


public interface UserRepository extends JpaRepository<User, Long> {
}

