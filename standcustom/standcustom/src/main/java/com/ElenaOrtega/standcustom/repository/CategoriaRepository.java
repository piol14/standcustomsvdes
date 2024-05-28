package com.ElenaOrtega.standcustom.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ElenaOrtega.standcustom.entity.CategoriaEntity;


public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Long> {




     
     @Query(value = "ALTER TABLE categoria AUTO_INCREMENT = 1", nativeQuery = true)
    void resetAutoIncrement();
    CategoriaEntity findByNombre(String nombre);
}
