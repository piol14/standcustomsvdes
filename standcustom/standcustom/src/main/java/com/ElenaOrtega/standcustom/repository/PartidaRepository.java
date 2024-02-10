package com.ElenaOrtega.standcustom.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.ElenaOrtega.standcustom.entity.PartidaEntity;
import com.ElenaOrtega.standcustom.entity.StandEntity;

public interface PartidaRepository extends JpaRepository<PartidaEntity, Long> {

    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE partida AUTO_INCREMENT = 1", nativeQuery = true)
    void resetAutoIncrement();
    Page<PartidaEntity> findByGanadorId(Long usuario, Pageable pageable); 
}
