package com.ElenaOrtega.standcustom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ElenaOrtega.standcustom.entity.PartidaEntity;
import com.ElenaOrtega.standcustom.repository.PartidaRepository;

@Service
public class PartidaService {

    @Autowired
    private PartidaRepository partidaRepository;

    public PartidaEntity get(Long id) {
        return partidaRepository.findById(id).orElse(null);
    }

    public Long create(PartidaEntity partidaEntity) {
        partidaRepository.save(partidaEntity);
        return partidaEntity.getId();
    }

    public PartidaEntity update(PartidaEntity updatedPartidaEntity) {
    
        return partidaRepository.save(updatedPartidaEntity);
    }

    public Long delete(Long id) {
        partidaRepository.deleteById(id);
        return id;
    }

    public Page<PartidaEntity> getPage(Pageable pageable, String strFilter) {
        // Implementa la lógica de paginación y filtrado según tus necesidades
        return partidaRepository.findAll(pageable);
    }
}
