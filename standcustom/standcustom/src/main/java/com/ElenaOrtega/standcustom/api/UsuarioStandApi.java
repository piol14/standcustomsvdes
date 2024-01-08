package com.ElenaOrtega.standcustom.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ElenaOrtega.standcustom.entity.UsuarioStandEntity;
import com.ElenaOrtega.standcustom.service.UsuarioStandService;

@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/usuarioStand")
public class UsuarioStandApi {

    @Autowired
    UsuarioStandService usuarioStandService;

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioStandEntity> get(@PathVariable("id") Long id) {
        return ResponseEntity.ok(usuarioStandService.get(id));
    }

    @PostMapping("")
    public ResponseEntity<Long> create(@RequestBody UsuarioStandEntity usuarioStandEntity) {
        return ResponseEntity.ok(usuarioStandService.create(usuarioStandEntity));
    }

    @PutMapping("")
    public ResponseEntity<UsuarioStandEntity> update(@RequestBody UsuarioStandEntity usuarioStandEntity) {
        return ResponseEntity.ok(usuarioStandService.update(usuarioStandEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable("id") Long id) {
        return ResponseEntity.ok(usuarioStandService.delete(id));
    }

    @GetMapping("")
    public ResponseEntity<Page<UsuarioStandEntity>> getPage(
            Pageable pageable,
            @RequestParam(name = "filter", required = false) String strFilter) {
        return ResponseEntity.ok(usuarioStandService.getPage(pageable, strFilter));
    }
}
