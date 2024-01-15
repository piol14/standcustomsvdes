package com.ElenaOrtega.standcustom.service;

import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ElenaOrtega.standcustom.entity.AtaqueStandEntity;
import com.ElenaOrtega.standcustom.entity.StandEntity;
import com.ElenaOrtega.standcustom.entity.UserEntity;
import com.ElenaOrtega.standcustom.repository.AtaqueStandRepository;
import com.ElenaOrtega.standcustom.repository.StandRepository;

@Service
public class StandService {

    @Autowired
    private StandRepository standRepository;
    @Autowired
    private AtaqueStandRepository ataqueRepository; 

    public StandEntity get(Long id) {
        return standRepository.findById(id).orElse(null);
    }

    public Long create(StandEntity standEntity) {
        standRepository.save(standEntity);
        return standEntity.getId();
    }

    public StandEntity update(StandEntity standEntity) {
        return standRepository.save(standEntity);
    }

    public Long delete(Long id) {
        standRepository.deleteById(id);
        return id;
    }

    public Page<StandEntity> getPage(Pageable pageable, String strFilter) {
        // Implementa la lógica de paginación y filtrado según tus necesidades
        return standRepository.findAll(pageable);
    }

 public Long populate(Integer amount) {
  
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    for (int i = 0; i < amount; i++) {
        StandEntity stand = new StandEntity();

        // Crear un ataque stand ficticio
        AtaqueStandEntity ataque = ataqueRepository.findById(12L).orElse(null);
        // Otros datos del stand
        stand.setNombre("Nombre del Stand " + i);
        stand.setDescripcion("Descripción del Stand " + i);
        
        // Establecer la relación entre el stand y el ataque stand
        stand.setAtaque(ataque);

        // Guardar el stand en la base de datos
        standRepository.save(stand);
    }
    return amount.longValue();
}


    public Long empty() {
        // Implementa la lógica para eliminar todos los registros de la entidad
        long countBeforeDeletion = standRepository.count();
        standRepository.deleteAll();
        long countAfterDeletion = standRepository.count();
        return countBeforeDeletion - countAfterDeletion;
    }
}
