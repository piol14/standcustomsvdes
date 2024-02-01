package com.ElenaOrtega.standcustom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ElenaOrtega.standcustom.entity.DetallePartidaEntity;
import com.ElenaOrtega.standcustom.repository.DetallePartidaRepository;

@Service
public class DetallePartidaService {
 
    @Autowired
    private SessionService oSessionService;
    @Autowired
    private DetallePartidaRepository detallePartidaRepository;
    @Autowired
    private PartidaService partidaService;
 @Autowired
    private StandService standService;
    @Autowired  
    private UserService usuarioService;

    
    public DetallePartidaEntity get(Long id) {
        return detallePartidaRepository.findById(id).orElse(null);
    }

    public Long create(DetallePartidaEntity usuarioStandEntity) {
    oSessionService.onlyAdminsOrUsers();
        detallePartidaRepository.save(usuarioStandEntity);
        return usuarioStandEntity.getId();
    }

    public DetallePartidaEntity update(DetallePartidaEntity updatedDetallePartidaEntity) {
         DetallePartidaEntity oAlquilerEntityFromDatabase = this.get(updatedDetallePartidaEntity.getId());
    oSessionService.onlyAdminsOrUsersWithIisOwnData(oAlquilerEntityFromDatabase.getUsuario().getId());
       

        
        return detallePartidaRepository.save(updatedDetallePartidaEntity);
    }

    public Long delete(Long id) {

        DetallePartidaEntity oDetallePartidaEntityFromDatabase = this.get(id);
        oSessionService.onlyAdminsOrUsersWithIisOwnData(oDetallePartidaEntityFromDatabase.getUsuario().getId());
        detallePartidaRepository.deleteById(id);
        return id;
    }

    public Page<DetallePartidaEntity> getPage(Pageable pageable, String strFilter) {
      
        return detallePartidaRepository.findAll(pageable);
    }

    //populate
    public Long populate(Integer amount) {
       oSessionService.onlyAdmins();
        for (int i = 0; i < amount; i++) {
            DetallePartidaEntity usuarioStand = new DetallePartidaEntity();
            usuarioStand.setPartida(partidaService.getOneRandom());
            usuarioStand.setStand(standService.getOneRandom());
            usuarioStand.setUsuario(usuarioService.getOneRandom());
            detallePartidaRepository.save(usuarioStand);
        }
        return amount.longValue();
    }

    //el empty
    public Long empty() {
       oSessionService.onlyAdmins();
        detallePartidaRepository.deleteAll();
        return 0L;
    }
}

