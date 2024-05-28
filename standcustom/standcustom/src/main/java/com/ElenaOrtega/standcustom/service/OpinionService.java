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
    
 @Autowired 
 private SessionService oSessionService;
    @Autowired
    private UserService userService;

    @Autowired 
    StandService standService; 
    public OpinionEntity get(Long id) {
        return opinionRepository.findById(id).orElse(null);
    }

    public Long create(OpinionEntity opinionEntity) {
        oSessionService.onlyAdminsOrUsersWithIisOwnData(oSessionService.getSessionUser().getId());
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
    public Page<OpinionEntity> getOpinionesByUser(Long id_usuario, Pageable oPageable) {
        return opinionRepository.findByUserId(id_usuario, oPageable);
    }

    public Page<OpinionEntity> getOpinionesByStand(Long id_producto, Pageable oPageable) {
        return opinionRepository.findByStandId(id_producto, oPageable);
    }

    public Long populate(Integer amount) {
        oSessionService.onlyAdmins();
    for (int i = 0; i < amount; i++) {
               
        OpinionEntity opinion = new OpinionEntity();

       opinion.setUsuario(userService.getOneRandom());


        opinion.setDescripcion("Opinión " + i);
   

     
         opinion.setStand(standService.getOneRandom());

   
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
