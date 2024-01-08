package com.ElenaOrtega.standcustom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ElenaOrtega.standcustom.entity.StandEntity;
import com.ElenaOrtega.standcustom.repository.StandRepository;

@Service
public class StandService {

    @Autowired
    private StandRepository standRepository;

    public StandEntity get(Long id) {
        return standRepository.findById(id).orElse(null);
    }

    public Long create(StandEntity standEntity) {
        standRepository.save(standEntity);
        return standEntity.getId();
    }

    public StandEntity update(StandEntity standEntity) {
        return standRepository.save(standEntity);
    }

    public Long delete(Long id) {
        standRepository.deleteById(id);
        return id;
    }

    public Page<StandEntity> getPage(Pageable pageable, String strFilter) {
        // Implementa la lógica de paginación y filtrado según tus necesidades
        return standRepository.findAll(pageable);
    }

    public Long populate(Integer amount) {
        // Implementa la lógica de población según tus necesidades
        // Puedes utilizar un bucle similar al que has proporcionado en la pregunta original
        // Asegúrate de establecer la relación con usuarios de alguna manera (por ejemplo, asignando usuarios existentes)
        // Retorna la cantidad total de registros después de la operación de población
        return 0L; // Actualiza esto con la cantidad real de registros después de la operación
    }

    public Long empty() {
        // Implementa la lógica para eliminar todos los registros de la entidad
        long countBeforeDeletion = standRepository.count();
        standRepository.deleteAll();
        long countAfterDeletion = standRepository.count();
        return countBeforeDeletion - countAfterDeletion;
    }
}
