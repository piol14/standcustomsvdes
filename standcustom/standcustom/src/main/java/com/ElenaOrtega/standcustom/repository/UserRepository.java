package com.ElenaOrtega.standcustom.repository;



import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;

import com.ElenaOrtega.standcustom.entity.UserEntity;



public interface UserRepository extends JpaRepository<UserEntity, Long> {
     Optional<UserEntity> findByUsername(String username);
  
    

      Optional<UserEntity> findByToken(String token);

      Optional<UserEntity> findByTokenPassword(String tokenPassword);
    
      Optional<UserEntity> findByEmail(String email);
    Optional<UserEntity> findByUsernameAndPassword(String username, String password);
    @Query(value = "ALTER TABLE usuario AUTO_INCREMENT = 1", nativeQuery = true)
    void resetAutoIncrement();
}