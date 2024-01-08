package com.ElenaOrtega.standcustom.service;

import com.ElenaOrtega.standcustom.entity.AtaqueStandEntity;
import com.ElenaOrtega.standcustom.repository.AtaqueStandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AtaqueStandService {

    private final AtaqueStandRepository ataqueStandRepository;

    @Autowired
    public AtaqueStandService(AtaqueStandRepository ataquesStandRepository) {
        this.ataqueStandRepository = ataquesStandRepository;
    }

    public List<AtaqueStandEntity> getAllAtaques() {
        return ataqueStandRepository.findAll();
    }

    public Optional<AtaqueStandEntity> getAtaqueById(Long id) {
        return ataqueStandRepository.findById(id);
    }

    public Long createAtaque(AtaqueStandEntity ataqueStandEntity) {
        ataqueStandEntity.setId(null);
        ataqueStandRepository.save(ataqueStandEntity);
        return ataqueStandEntity.getId();
    }

    public AtaqueStandEntity updateAtaque(AtaqueStandEntity ataqueStandEntity) {
        return ataqueStandRepository.save(ataqueStandEntity);
    }

    public void deleteAtaque(Long id) {
        ataqueStandRepository.deleteById(id);
    }
}
