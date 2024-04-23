package com.ElenaOrtega.standcustom.repository;



import com.ElenaOrtega.standcustom.entity.FavoritoEntity;
import com.ElenaOrtega.standcustom.entity.OpinionEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;



public interface FavoritoRepository extends JpaRepository<FavoritoEntity, Long> {

  
    
   
    @Query(value = "ALTER TABLE stand AUTO_INCREMENT = 1", nativeQuery = true)
    void resetAutoIncrement();
}