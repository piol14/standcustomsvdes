package com.ElenaOrtega.standcustom.service;

import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import com.ElenaOrtega.standcustom.entity.PartidaEntity;
import com.ElenaOrtega.standcustom.entity.StandEntity;
import com.ElenaOrtega.standcustom.entity.UserEntity;
import com.ElenaOrtega.standcustom.repository.PartidaRepository;


@Service
public class PartidaService {

    @Autowired
    private PartidaRepository partidaRepository;
   
    @Autowired
    private SessionService oSessionService;
    @Autowired 
    private UserService userService;
    public PartidaEntity get(Long id) {
       
        return partidaRepository.findById(id).orElse(null);
    }

    public Long create(PartidaEntity partidaEntity) {
        oSessionService.onlyAdmins();
        partidaRepository.save(partidaEntity);
        return partidaEntity.getId();
    }

    public PartidaEntity update(PartidaEntity updatedPartidaEntity) {
    oSessionService.onlyAdmins();
        return partidaRepository.save(updatedPartidaEntity);
    }

    public Long delete(Long id) {
        oSessionService.onlyAdmins();
        partidaRepository.deleteById(id);
        return id;
    }

    public Page<PartidaEntity> getPage(Pageable pageable, String strFilter) {
        
        return partidaRepository.findAll(pageable);
    }

    public PartidaEntity getOneRandom() {
oSessionService.onlyAdmins();
        Pageable oPageable = PageRequest.of((int) (Math.random() * partidaRepository.count()), 1);
        return partidaRepository.findAll(oPageable).getContent().get(0);
    }
     public Long populate(Integer amount) {
  oSessionService.onlyAdmins();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    for (int i = 0; i < amount; i++) {

        PartidaEntity partida = new PartidaEntity();
        // Crear un ataque stand ficticio
        partida.setGanador(userService.getOneRandom());
        // Otros datos del stand
       
        // Establecer la relación entre el stand y el ataque stand
       partida.setFecha("12-12-2024");;
       
        // Guardar el stand en la base de datos
       partidaRepository.save(partida);
    }
    return amount.longValue();
}
public Long empty() {
         oSessionService.onlyAdmins();

        partidaRepository.deleteAll();
        partidaRepository.resetAutoIncrement();
        partidaRepository.flush();
        return partidaRepository.count();
    }
}
