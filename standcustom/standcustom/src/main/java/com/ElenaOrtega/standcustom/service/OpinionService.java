package com.ElenaOrtega.standcustom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ElenaOrtega.standcustom.entity.OpinionEntity;
import com.ElenaOrtega.standcustom.repository.OpinionRepository;

@Service
public class OpinionService {

    @Autowired
    private OpinionRepository opinionRepository;

    public OpinionEntity get(Long id) {
        return opinionRepository.findById(id).orElse(null);
    }

    public Long create(OpinionEntity opinionEntity) {
        opinionRepository.save(opinionEntity);
        return opinionEntity.getId();
    }

    public OpinionEntity update(OpinionEntity updatedOpinionEntity) {
        return opinionRepository.save(updatedOpinionEntity);
    }

    public Long delete(Long id) {
        opinionRepository.deleteById(id);
        return id;
    }

    public Page<OpinionEntity> getPage(Pageable pageable, String strFilter) {
        // Implementa la lógica de paginación y filtrado según tus necesidades
        return opinionRepository.findAll(pageable);
    }
}
