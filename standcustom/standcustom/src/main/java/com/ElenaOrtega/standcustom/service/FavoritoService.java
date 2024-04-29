package com.ElenaOrtega.standcustom.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;


import com.ElenaOrtega.standcustom.entity.FavoritoEntity;
import com.ElenaOrtega.standcustom.entity.OpinionEntity;
import com.ElenaOrtega.standcustom.repository.FavoritoRepository;

@Service
public class FavoritoService {

    @Autowired
    private FavoritoRepository favoritoRepository;

    @Autowired
    private SessionService sessionService;

    @Autowired
    private UserService userService;
    @Autowired
    private StandService standService;
    // Método para obtener un favorito por su ID
    public FavoritoEntity get(Long id) {
        return favoritoRepository.findById(id).orElse(null);
    }

    // Método para crear un nuevo favorito
    public Long create(FavoritoEntity favoritoEntity) {
        sessionService.onlyAdminsOrUsersWithIisOwnData(favoritoEntity.getUsuario().getId());
        favoritoRepository.save(favoritoEntity);
        return favoritoEntity.getId();
    }

    // Método para actualizar un favorito existente
    public FavoritoEntity update(FavoritoEntity updatedFavoritoEntity) {
        sessionService.onlyAdminsOrUsersWithIisOwnData(sessionService.getSessionUser().getId());
        return favoritoRepository.save(updatedFavoritoEntity);
    }

    // Método para eliminar un favorito por su ID
    public Long delete(Long id) {
        sessionService.onlyAdmins();
        favoritoRepository.deleteById(id);
        return id;
    }

    // Método para obtener una página de favoritos
    public Page<FavoritoEntity> getPage(Pageable pageable, Long userId, Long standId) {
        sessionService.onlyAdmins();
    
        if (userId == null || userId == 0) {
            if (standId == null || standId == 0) {
                return  favoritoRepository.findAll(pageable);
            } else {
                return  favoritoRepository.findByStandId(standId, pageable);
            }
        } else {
            return  favoritoRepository.findByUserId(userId, pageable);
        }
    }
    
 public Page<FavoritoEntity> getOpinionesByUser(Long id_usuario, Pageable oPageable) {
        return favoritoRepository.findByUserId(id_usuario, oPageable);
    }

    public Page<FavoritoEntity> getOpinionesByStand(Long id_producto, Pageable oPageable) {
        return favoritoRepository.findByStandId(id_producto, oPageable);
    }
    // Método para obtener un favorito aleatorio
    public FavoritoEntity getOneRandom() {
        sessionService.onlyAdmins();
        long count = favoritoRepository.count();
        int randomPage = (int) (Math.random() * count);
        return favoritoRepository.findAll(PageRequest.of(randomPage, 1)).getContent().get(0);
    }

    // Método para llenar la base de datos con una cantidad específica de favoritos
    public Long populate(int amount) {
        sessionService.onlyAdmins();
        for (int i = 0; i < amount; i++) {
            FavoritoEntity favorito = new FavoritoEntity();
            favorito.setUsuario(userService.getOneRandom());
            favorito.setStand(standService.getOneRandom());
            favoritoRepository.save(favorito);
        }
        return (long) amount;
    }

    // Método para vaciar la tabla de favoritos
    public Long empty() {
        sessionService.onlyAdmins();
        favoritoRepository.deleteAll();
        // Necesario para reiniciar el auto incremento del ID en algunas bases de datos
        favoritoRepository.resetAutoIncrement();
        return favoritoRepository.count();
    }
    public boolean existeFavoritoRepetido(Long usuarioId, Long standId) {
        Page<FavoritoEntity> favoritos = favoritoRepository.findByUsuarioIdAndStandId(usuarioId, standId, Pageable.unpaged());
        return favoritos.getTotalElements() > 0;
    }
    
    // Método para obtener el ID de un favorito repetido para un usuario y un stand
    public Optional<Long> obtenerFavoritoRepetidoId(Long usuarioId, Long standId) {
        Page<FavoritoEntity> favoritos = favoritoRepository.findByUsuarioIdAndStandId(usuarioId, standId, Pageable.unpaged());
        if (favoritos.getTotalElements() > 0) {
            FavoritoEntity favoritoRepetido = favoritos.getContent().get(0);
            return Optional.of(favoritoRepetido.getId());
        } else {
            return Optional.empty();
        }
    }
  
}
