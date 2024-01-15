package com.ElenaOrtega.standcustom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ElenaOrtega.standcustom.entity.OpinionEntity;
import com.ElenaOrtega.standcustom.entity.StandEntity;
import com.ElenaOrtega.standcustom.entity.UserEntity;
import com.ElenaOrtega.standcustom.repository.OpinionRepository;
import com.ElenaOrtega.standcustom.repository.StandRepository;
import com.ElenaOrtega.standcustom.repository.UserRepository;

@Service
public class OpinionService {

    @Autowired
    private OpinionRepository opinionRepository;
    @Autowired
    private UserRepository oUserRepository;
    @Autowired
    private StandRepository standRepository;
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
    public Long populate(Integer amount) {
  
    for (int i = 0; i < amount; i++) {
        OpinionEntity opinion = new OpinionEntity();

        // Asignar un usuario existente
        UserEntity usuario = oUserRepository.findById(1L).orElse(null);
        if (usuario == null) {
            throw new IllegalArgumentException("No se encontró un usuario con ID 1");
        }
        opinion.setUsuario(usuario);

        // Datos de la opinión
        opinion.setDescripcion("Opinión " + i);
        opinion.setNumero_estrellas((i % 5) + 1); // Asignar estrellas del 1 al 5

        // Asignar un stand existente
        StandEntity stand = standRepository.findById(1L).orElse(null);
        if (stand == null) {
            throw new IllegalArgumentException("No se encontró un stand con ID 1");
        }
        opinion.setStand(stand);

        // Guardar la opinión en la base de datos
        opinionRepository.save(opinion);
    }
    return amount.longValue();
}
  public Long empty() {
       
        opinionRepository.deleteAll();
        opinionRepository.resetAutoIncrement();
        opinionRepository.flush();
        return opinionRepository.count();
    }
}
