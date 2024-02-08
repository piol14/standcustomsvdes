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
 @Autowired 
 private SessionService oSessionService;
    @Autowired
    private UserService userService;

    @Autowired StandService standService; 
    public OpinionEntity get(Long id) {
        return opinionRepository.findById(id).orElse(null);
    }

    public Long create(OpinionEntity opinionEntity) {
        oSessionService.onlyAdminsOrUsers();
        opinionRepository.save(opinionEntity);
        return opinionEntity.getId();
    }

    public OpinionEntity update(OpinionEntity updatedOpinionEntity) {
          OpinionEntity oOpinionEntityFromDatabase = this.get(updatedOpinionEntity.getId());
    oSessionService.onlyAdminsOrUsersWithIisOwnData(oOpinionEntityFromDatabase.getUsuario().getId());
        return opinionRepository.save(updatedOpinionEntity);
    }

    public Long delete(Long id) {
         OpinionEntity oOpinionEntityFromDatabase = this.get(id);
        oSessionService.onlyAdminsOrUsersWithIisOwnData(oOpinionEntityFromDatabase.getUsuario().getId());
        opinionRepository.deleteById(id);
        return id;
    }

    public Page<OpinionEntity> getPage(Pageable pageable, Long userId, Long standId) {
        oSessionService.onlyAdmins();
    
        if (userId == null || userId == 0) {
            if (standId == null || standId == 0) {
                return opinionRepository.findAll(pageable);
            } else {
                return opinionRepository.findByStandId(standId, pageable);
            }
        } else {
            return opinionRepository.findByUserId(userId, pageable);
        }
    }


    public Long populate(Integer amount) {
        oSessionService.onlyAdmins();
    for (int i = 0; i < amount; i++) {
               
        OpinionEntity opinion = new OpinionEntity();

        // Asignar un usuario existente
       opinion.setUsuario(userService.getOneRandom());

        // Datos de la opinión
        opinion.setDescripcion("Opinión " + i);
        opinion.setNumero_estrellas((i % 5) + 1); // Asignar estrellas del 1 al 5

        // Asignar un stand existente
         opinion.setStand(standService.getOneRandom());

        // Guardar la opinión en la base de datos
        opinionRepository.save(opinion);
    }
    return amount.longValue();
}
  public Long empty() {
               oSessionService.onlyAdmins();

        opinionRepository.deleteAll();
        opinionRepository.resetAutoIncrement();
        opinionRepository.flush();
        return opinionRepository.count();
    }
}
