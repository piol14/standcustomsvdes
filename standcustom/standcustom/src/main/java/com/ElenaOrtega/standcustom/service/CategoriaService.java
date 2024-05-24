package com.ElenaOrtega.standcustom.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ElenaOrtega.standcustom.entity.CategoriaEntity;
import com.ElenaOrtega.standcustom.entity.PartidaEntity;
import com.ElenaOrtega.standcustom.entity.CategoriaEntity;
import com.ElenaOrtega.standcustom.repository.CategoriaRepository;
import com.ElenaOrtega.standcustom.repository.DetallePartidaRepository;

@Service
public class CategoriaService {
 
    @Autowired
    private SessionService oSessionService;
   
@Autowired
private CategoriaRepository categoriaRepository;
    
    public CategoriaEntity get(Long id) {
        return categoriaRepository.findById(id).orElse(null);
    }

    public Long create(CategoriaEntity usuarioStandEntity) {
    oSessionService.onlyAdminsOrUsers();
    categoriaRepository.save(usuarioStandEntity);
        return usuarioStandEntity.getId();
    }

    public CategoriaEntity update(CategoriaEntity updatedCategoriaEntity) {
         CategoriaEntity oAlquilerEntityFromDatabase = this.get(updatedCategoriaEntity.getId());
    oSessionService.onlyAdmins();
       

        
        return categoriaRepository.save(updatedCategoriaEntity);
    }

    public Long delete(Long id) {

        CategoriaEntity oCategoriaEntityFromDatabase = this.get(id);
        oSessionService.onlyAdmins();
        categoriaRepository.deleteById(id);
        return id;
    }
    public CategoriaEntity findByNombre(String nombre) {
        return categoriaRepository.findByNombre(nombre);
    }
    
    public Page<CategoriaEntity> getPage(Pageable pageable) {
       
         return categoriaRepository.findAll(pageable);
       
       
    }



    public CategoriaEntity getOneRandom() {

oSessionService.onlyAdmins();
        Pageable oPageable = PageRequest.of((int) (Math.random() * categoriaRepository.count()), 1);
        return categoriaRepository.findAll(oPageable).getContent().get(0);
    }


   public Long populate(Integer amount) {
    oSessionService.onlyAdmins();




String[] nombresCategorias = {
    "Phantom Blood",
    "Battle Tendency",
    "Stardust Crusaders",
    "Diamond is Unbreakable",
    "Vento Aureo",
    "Stone Ocean",
    "Steel Ball Run",
    "Jojolion",
    "Custom" 
};

    List<CategoriaEntity> categorias = new ArrayList<>();

    for (int i = 0; i < amount && i < nombresCategorias.length; i++) {
        CategoriaEntity categoria = new CategoriaEntity();
        categoria.setNombre(nombresCategorias[i]);
        categorias.add(categoria);
    }

    categoriaRepository.saveAll(categorias);

    return Long.valueOf(categorias.size());
}


   
    public Long empty() {
       oSessionService.onlyAdmins();
       categoriaRepository.deleteAll();
        return 0L;
    }
}

