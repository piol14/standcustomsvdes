package com.ElenaOrtega.standcustom.service;

import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ElenaOrtega.standcustom.entity.AtaqueStandEntity;
import com.ElenaOrtega.standcustom.entity.PartidaEntity;
import com.ElenaOrtega.standcustom.entity.StandEntity;
import com.ElenaOrtega.standcustom.entity.UserEntity;
import com.ElenaOrtega.standcustom.repository.PartidaRepository;
import com.ElenaOrtega.standcustom.repository.UserRepository;

@Service
public class PartidaService {

    @Autowired
    private PartidaRepository partidaRepository;
    @Autowired
    private UserRepository oUserRepository;
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
     public Long populate(Integer amount) {
  
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    for (int i = 0; i < amount; i++) {

        PartidaEntity partida = new PartidaEntity();
        // Crear un ataque stand ficticio
        UserEntity user = oUserRepository.findById(1L).orElse(null);
        // Otros datos del stand
       
        // Establecer la relación entre el stand y el ataque stand
       partida.setFecha("12-12-2024");;
        partida.setGanador(user);
        // Guardar el stand en la base de datos
       partidaRepository.save(partida);
    }
    return amount.longValue();
}
public Long empty() {
       
        partidaRepository.deleteAll();
        partidaRepository.resetAutoIncrement();
        partidaRepository.flush();
        return partidaRepository.count();
    }
}
