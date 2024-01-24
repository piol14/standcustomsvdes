package com.ElenaOrtega.standcustom.service;

import com.ElenaOrtega.standcustom.entity.AtaqueStandEntity;
import com.ElenaOrtega.standcustom.repository.AtaqueStandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    
public AtaqueStandEntity getOneRandom() {

        Pageable oPageable = PageRequest.of((int) (Math.random() * ataqueStandRepository.count()), 1);
        return ataqueStandRepository.findAll(oPageable).getContent().get(0);
    }
    public AtaqueStandEntity updateAtaque(AtaqueStandEntity ataqueStandEntity) {
        return ataqueStandRepository.save(ataqueStandEntity);
    }

    public void deleteAtaque(Long id) {
        ataqueStandRepository.deleteById(id);
    }
     public Long populate(Integer amount) {
        for (int i = 0; i < amount; i++) {
            AtaqueStandEntity ataque = new AtaqueStandEntity(
                "A" , "B" , "C" , "D", "E" , "A" 
            );
            ataqueStandRepository.save(ataque);
        }
        return amount.longValue();
    }

     public Long empty() {
        
        long countBeforeDeletion = ataqueStandRepository.count();
       ataqueStandRepository.deleteAll();
        long countAfterDeletion = ataqueStandRepository.count();
        return countBeforeDeletion - countAfterDeletion;
    }
}
