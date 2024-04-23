package com.ElenaOrtega.standcustom.api;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ElenaOrtega.standcustom.entity.FavoritoEntity;
import com.ElenaOrtega.standcustom.entity.OpinionEntity;
import com.ElenaOrtega.standcustom.service.FavoritoService;

@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/favorito")
public class FavoritoApi {
    private static final int PAGE_TAMANYO = 10;
    @Autowired
    FavoritoService favoritoService;

    @GetMapping("/{id}")
    public ResponseEntity<FavoritoEntity> get(@PathVariable("id") Long id) {
        return ResponseEntity.ok(favoritoService.get(id));
    }

    @PostMapping("")
    public ResponseEntity<Long> create(@RequestBody FavoritoEntity favoritoEntity) {
        return ResponseEntity.ok(favoritoService.create(favoritoEntity));
    }

    @PutMapping("")
    public ResponseEntity<FavoritoEntity> update(@RequestBody FavoritoEntity favoritoEntity) {
        return ResponseEntity.ok(favoritoService.update(favoritoEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable("id") Long id) {
        return ResponseEntity.ok(favoritoService.delete(id));
    }

    @GetMapping("")
    public ResponseEntity<Page<FavoritoEntity>> getPage(
        Pageable oPageable
     
        ) {
            return ResponseEntity.ok(favoritoService.getPage(oPageable ));
        }
      @PostMapping("/populate/{amount}")
    public ResponseEntity<Long> populate(@PathVariable("amount") Integer amount) {
        return ResponseEntity.ok(favoritoService.populate(amount));
    }
     @DeleteMapping("/empty")
    public ResponseEntity<Long> empty() {
        return ResponseEntity.ok(favoritoService.empty());
    }
}
