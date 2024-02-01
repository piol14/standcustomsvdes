package com.ElenaOrtega.standcustom.repository;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ElenaOrtega.standcustom.entity.DetallePartidaEntity;

public interface DetallePartidaRepository extends JpaRepository<DetallePartidaEntity, Long> {
}