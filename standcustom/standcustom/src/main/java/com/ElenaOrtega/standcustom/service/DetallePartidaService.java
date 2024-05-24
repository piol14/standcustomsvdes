package com.ElenaOrtega.standcustom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ElenaOrtega.standcustom.entity.DetallePartidaEntity;
import com.ElenaOrtega.standcustom.entity.OpinionEntity;
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

    public Long create(DetallePartidaEntity detallePartidaEntity) {
        oSessionService.onlyAdminsOrUsersWithIisOwnData(oSessionService.getSessionUser().getId());
        detallePartidaRepository.save(detallePartidaEntity);
        return detallePartidaEntity.getId();
    }

    public DetallePartidaEntity update(DetallePartidaEntity updatedDetallePartidaEntity) {
        DetallePartidaEntity detallePartidaEntityFromDatabase = this.get(updatedDetallePartidaEntity.getId());
        oSessionService.onlyAdminsOrUsersWithIisOwnData(detallePartidaEntityFromDatabase.getUsuario().getId());
        return detallePartidaRepository.save(updatedDetallePartidaEntity);
    }

    public Long delete(Long id) {
        DetallePartidaEntity detallePartidaEntityFromDatabase = this.get(id);
        oSessionService.onlyAdminsOrUsersWithIisOwnData(detallePartidaEntityFromDatabase.getUsuario().getId());
        detallePartidaRepository.deleteById(id);
        return id;
    }

    public Page<DetallePartidaEntity> getPage(Pageable pageable, String strFilter, Long userId, Long standId, Long partidaId) {
        if (userId == null || userId == 0) {
            if (standId == null || standId == 0) {
                if (partidaId == null || partidaId == 0) {
                    return detallePartidaRepository.findAll(pageable);
                } else {
                 
                    return detallePartidaRepository.findByPartidaId(partidaId, pageable);
                }
            } else {
                return detallePartidaRepository.findByStandId(standId, pageable);
            }
        } else {
            return detallePartidaRepository.findByUsuarioId(userId, pageable);
        }
    }
 public Page<DetallePartidaEntity> getDetallePartidaByUser(Long id_usuario, Pageable oPageable) {
        return detallePartidaRepository.findByUsuarioId(id_usuario, oPageable);
    }

    public Page<DetallePartidaEntity> getDetallePartidaByStand(Long id_producto, Pageable oPageable) {
        return detallePartidaRepository.findByStandId(id_producto, oPageable);
    }
    public Long populate(Integer amount) {
        oSessionService.onlyAdmins();
        for (int i = 0; i < amount; i++) {
            DetallePartidaEntity detallePartidaEntity = new DetallePartidaEntity();
            detallePartidaEntity.setPartida(partidaService.getOneRandom());
            detallePartidaEntity.setStand(standService.getOneRandom());
            detallePartidaEntity.setUsuario(usuarioService.getOneRandom());
            detallePartidaRepository.save(detallePartidaEntity);
        }
        return amount.longValue();
    }

    public Long empty() {
        oSessionService.onlyAdmins();
        detallePartidaRepository.deleteAll();
        return 0L;
    }
}
