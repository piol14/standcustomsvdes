package com.ElenaOrtega.standcustom.repository;



import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ElenaOrtega.standcustom.entity.OpinionEntity;
import com.ElenaOrtega.standcustom.entity.StandEntity;
import com.ElenaOrtega.standcustom.entity.UserEntity;



public interface StandRepository extends JpaRepository<StandEntity, Long> {

    Page<StandEntity> findByUsuarioId(Long usuario, Pageable pageable);
    Page<StandEntity> findByCategoriaId(Long categoria, Pageable pageable);
    
   
    @Query(value = "ALTER TABLE stand AUTO_INCREMENT = 1", nativeQuery = true)
    void resetAutoIncrement();
}