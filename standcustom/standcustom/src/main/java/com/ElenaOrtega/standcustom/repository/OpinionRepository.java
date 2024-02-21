

package com.ElenaOrtega.standcustom.repository;

import com.ElenaOrtega.standcustom.entity.OpinionEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface OpinionRepository extends JpaRepository<OpinionEntity, Long> {

   
    @Query("SELECT o FROM OpinionEntity o WHERE o.usuario.id = :userId")
    Page<OpinionEntity> findByUserId(Long userId, Pageable pageable);

  
    Page<OpinionEntity> findByStandId(Long standId, Pageable pageable);
    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE opinion AUTO_INCREMENT = 1", nativeQuery = true)
    void resetAutoIncrement();
}