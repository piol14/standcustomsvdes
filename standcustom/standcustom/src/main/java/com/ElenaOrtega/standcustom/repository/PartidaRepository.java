package com.ElenaOrtega.standcustom.repository;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ElenaOrtega.standcustom.entity.PartidaEntity;



public interface PartidaRepository extends JpaRepository<PartidaEntity, Long> {
     @Query(value = "ALTER TABLE partida AUTO_INCREMENT = 1", nativeQuery = true)
    void resetAutoIncrement();
}