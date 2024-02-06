package com.ElenaOrtega.standcustom.repository;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ElenaOrtega.standcustom.entity.CategoriaEntity;
import com.ElenaOrtega.standcustom.entity.DetallePartidaEntity;

public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Long> {


     
     @Query(value = "ALTER TABLE categoria AUTO_INCREMENT = 1", nativeQuery = true)
    void resetAutoIncrement();
}
