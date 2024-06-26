package com.ElenaOrtega.standcustom.repository;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.ElenaOrtega.standcustom.entity.FavoritoEntity;



public interface FavoritoRepository extends JpaRepository<FavoritoEntity, Long> {

  
    
    @Query("SELECT o FROM FavoritoEntity o WHERE o.usuario.id = :userId")
    Page<FavoritoEntity> findByUserId(Long userId, Pageable pageable);

  
    Page<FavoritoEntity> findByStandId(Long standId, Pageable pageable);
    Page<FavoritoEntity> findByUsuarioIdAndStandId(Long usuarioId, Long standId, Pageable pageable);
    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE favorito AUTO_INCREMENT = 1", nativeQuery = true)
    void resetAutoIncrement();
}