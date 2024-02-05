package com.ElenaOrtega.standcustom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.ElenaOrtega.standcustom.entity.PartidaEntity;

public interface PartidaRepository extends JpaRepository<PartidaEntity, Long> {

    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE partida AUTO_INCREMENT = 1", nativeQuery = true)
    void resetAutoIncrement();
}
