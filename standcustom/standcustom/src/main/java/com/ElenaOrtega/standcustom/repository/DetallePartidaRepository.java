package com.ElenaOrtega.standcustom.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ElenaOrtega.standcustom.entity.DetallePartidaEntity;

public interface DetallePartidaRepository extends JpaRepository<DetallePartidaEntity, Long> {

    Page<DetallePartidaEntity> findByStandId(Long id, Pageable pageable);
    Page<DetallePartidaEntity> findByPartidaId(Long id , Pageable pageable);
    Page<DetallePartidaEntity> findByUsuarioId (Long id , Pageable pageable);
}