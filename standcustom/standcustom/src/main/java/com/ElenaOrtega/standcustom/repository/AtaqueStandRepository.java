package com.ElenaOrtega.standcustom.repository;

import com.ElenaOrtega.standcustom.entity.AtaqueStandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AtaqueStandRepository extends JpaRepository<AtaqueStandEntity, Long> {
     @Query(value = "ALTER TABLE ataque_stand AUTO_INCREMENT = 1", nativeQuery = true)
    void resetAutoIncrement();
}
