package com.ing.cruddocker.repositories;

import com.ing.cruddocker.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
