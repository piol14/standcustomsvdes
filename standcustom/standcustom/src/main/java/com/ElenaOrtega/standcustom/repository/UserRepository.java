package com.ElenaOrtega.standcustom.repository;



import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ElenaOrtega.standcustom.entity.UserEntity;



public interface UserRepository extends JpaRepository<UserEntity, Long> {
     Optional<UserEntity> findByUsername(String username);
  @Query(value = "SELECT * FROM usuario WHERE length(?1) >= 3 AND (nombre LIKE %?1% OR username LIKE %?1% OR email LIKE %?1%)", nativeQuery = true)
  Page<UserEntity> findByUserByNameOrSurnameOrLastnameContainingIgnoreCase(String searchText,
      String filter, String filter2, String filter3, Pageable pageable);

      Optional<UserEntity> findByToken(String token);

      Optional<UserEntity> findByTokenPassword(String tokenPassword);
    
      Optional<UserEntity> findByEmail(String email);
    Optional<UserEntity> findByUsernameAndPassword(String username, String password);
    @Query(value = "ALTER TABLE usuario AUTO_INCREMENT = 1", nativeQuery = true)
    void resetAutoIncrement();
}