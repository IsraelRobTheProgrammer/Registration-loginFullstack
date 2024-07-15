package com.example.test.repository;

import com.example.test.entity.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserDto, Integer> {
    Optional<UserDto> findByMatricAndPassword(Long matric, String password);
    Optional<UserDto> findFirstByMatric(Long matric);

}
