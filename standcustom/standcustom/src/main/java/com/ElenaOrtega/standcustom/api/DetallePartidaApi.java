package com.ElenaOrtega.standcustom.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ElenaOrtega.standcustom.entity.DetallePartidaEntity;
import com.ElenaOrtega.standcustom.service.DetallePartidaService;

@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/detallePartida")
public class DetallePartidaApi {

    @Autowired
    DetallePartidaService usuarioStandService;

    @GetMapping("/{id}")
    public ResponseEntity<DetallePartidaEntity> get(@PathVariable("id") Long id) {
        return ResponseEntity.ok(usuarioStandService.get(id));
    }

    @PostMapping("")
    public ResponseEntity<Long> create(@RequestBody DetallePartidaEntity usuarioStandEntity) {
        return ResponseEntity.ok(usuarioStandService.create(usuarioStandEntity));
    }

    @PutMapping("")
    public ResponseEntity<DetallePartidaEntity> update(@RequestBody DetallePartidaEntity usuarioStandEntity) {
        return ResponseEntity.ok(usuarioStandService.update(usuarioStandEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable("id") Long id) {
        return ResponseEntity.ok(usuarioStandService.delete(id));
    }

    @GetMapping("")
    public ResponseEntity<Page<DetallePartidaEntity>> getPage(
            Pageable pageable,
            @RequestParam(name = "filter", required = false) String strFilter) {
        return ResponseEntity.ok(usuarioStandService.getPage(pageable, strFilter));
    }

    @PostMapping("/populate/{amount}")
    public ResponseEntity<Long> populate(@PathVariable("amount") Integer amount) {
        return ResponseEntity.ok(usuarioStandService.populate(amount));
    }
}
