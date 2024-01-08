package com.ElenaOrtega.standcustom.api;

import com.ElenaOrtega.standcustom.entity.AtaqueStandEntity;
import com.ElenaOrtega.standcustom.entity.OpinionEntity;
import com.ElenaOrtega.standcustom.service.AtaqueStandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ataques")
public class AtaqueStandApi {

    private final AtaqueStandService ataquesStandService;

    @Autowired
    public AtaqueStandApi(AtaqueStandService ataquesStandService) {
        this.ataquesStandService = ataquesStandService;
    }

    @GetMapping
    public ResponseEntity<List<AtaqueStandEntity>> getAllAtaques() {
        return ResponseEntity.ok(ataquesStandService.getAllAtaques());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AtaqueStandEntity> getAtaqueById(@PathVariable Long id) {
        return ataquesStandService.getAtaqueById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
       public ResponseEntity<Long> create(@RequestBody AtaqueStandEntity ataqueStandEntity) {
        return ResponseEntity.ok(ataquesStandService.create(ataqueStandEntity));
    }
   

    @PutMapping("/{id}")
    public ResponseEntity<AtaqueStandEntity> updateAtaque(@PathVariable Long id, @RequestBody AtaqueStandEntity ataquesStandEntity) {
        if (!ataquesStandService.getAtaqueById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        ataquesStandEntity.setId(id);
        return ResponseEntity.ok(ataquesStandService.updateAtaque(ataquesStandEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAtaque(@PathVariable Long id) {
        if (!ataquesStandService.getAtaqueById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        ataquesStandService.deleteAtaque(id);
        return ResponseEntity.noContent().build();
    }
}
