package com.ElenaOrtega.standcustom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ElenaOrtega.standcustom.entity.UsuarioStandEntity;
import com.ElenaOrtega.standcustom.repository.UsuarioStandRepository;

@Service
public class UsuarioStandService {

    @Autowired
    private UsuarioStandRepository usuarioStandRepository;
    @Autowired
    private PartidaService partidaService;
 @Autowired
    private StandService standService;
    @Autowired  
    private UserService usuarioService;
    public UsuarioStandEntity get(Long id) {
        return usuarioStandRepository.findById(id).orElse(null);
    }

    public Long create(UsuarioStandEntity usuarioStandEntity) {
        usuarioStandRepository.save(usuarioStandEntity);
        return usuarioStandEntity.getId();
    }

    public UsuarioStandEntity update(UsuarioStandEntity updatedUsuarioStandEntity) {
        return usuarioStandRepository.save(updatedUsuarioStandEntity);
    }

    public Long delete(Long id) {
        usuarioStandRepository.deleteById(id);
        return id;
    }

    public Page<UsuarioStandEntity> getPage(Pageable pageable, String strFilter) {
        // Implementa la lógica de paginación y filtrado según tus necesidades
        return usuarioStandRepository.findAll(pageable);
    }

    //populate
    public Long populate(Integer amount) {
        for (int i = 0; i < amount; i++) {
            UsuarioStandEntity usuarioStand = new UsuarioStandEntity();
            usuarioStand.setPartida(partidaService.getOneRandom());
            usuarioStand.setStand(standService.getOneRandom());
            usuarioStand.setUsuario(usuarioService.getOneRandom());
            usuarioStandRepository.save(usuarioStand);
        }
        return amount.longValue();
    }
}

