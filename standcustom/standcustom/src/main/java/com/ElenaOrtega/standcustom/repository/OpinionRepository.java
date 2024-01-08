package com.ElenaOrtega.standcustom.repository;
import com.ElenaOrtega.standcustom.entity.OpinionEntity;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
public interface OpinionRepository extends JpaRepository<OpinionEntity, Long> {
}