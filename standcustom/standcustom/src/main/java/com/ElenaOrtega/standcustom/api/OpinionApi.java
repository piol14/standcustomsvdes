package com.ElenaOrtega.standcustom.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ElenaOrtega.standcustom.entity.OpinionEntity;
import com.ElenaOrtega.standcustom.service.OpinionService;

@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/opinion")
public class OpinionApi {

    @Autowired
    OpinionService opinionService;

    @GetMapping("/{id}")
    public ResponseEntity<OpinionEntity> get(@PathVariable("id") Long id) {
        return ResponseEntity.ok(opinionService.get(id));
    }

    @PostMapping("")
    public ResponseEntity<Long> create(@RequestBody OpinionEntity opinionEntity) {
        return ResponseEntity.ok(opinionService.create(opinionEntity));
    }

    @PutMapping("")
    public ResponseEntity<OpinionEntity> update(@RequestBody OpinionEntity opinionEntity) {
        return ResponseEntity.ok(opinionService.update(opinionEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable("id") Long id) {
        return ResponseEntity.ok(opinionService.delete(id));
    }

    @GetMapping("")
    public ResponseEntity<Page<OpinionEntity>> getPage(
        Pageable oPageable,
        @RequestParam(value = "usuario", defaultValue = "0", required = false) Long userId
        ) {
            return ResponseEntity.ok(opinionService.getPage(oPageable , userId));
        }
      @PostMapping("/populate/{amount}")
    public ResponseEntity<Long> populate(@PathVariable("amount") Integer amount) {
        return ResponseEntity.ok(opinionService.populate(amount));
    }
     @DeleteMapping("/empty")
    public ResponseEntity<Long> empty() {
        return ResponseEntity.ok(opinionService.empty());
    }
}
