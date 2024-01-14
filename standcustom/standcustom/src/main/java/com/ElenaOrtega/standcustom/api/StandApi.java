package com.ElenaOrtega.standcustom.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ElenaOrtega.standcustom.entity.StandEntity;
import com.ElenaOrtega.standcustom.service.StandService;

@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/stand")
public class StandApi {

    @Autowired
    StandService standService;

    @GetMapping("/{id}")
    public ResponseEntity<StandEntity> get(@PathVariable("id") Long id) {
        return ResponseEntity.ok(standService.get(id));
    }

    @PostMapping("")
    public ResponseEntity<Long> create(@RequestBody StandEntity standEntity) {
        return ResponseEntity.ok(standService.create(standEntity));
    }

    @PutMapping("")
    public ResponseEntity<StandEntity> update(@RequestBody StandEntity standEntity) {
        return ResponseEntity.ok(standService.update(standEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable("id") Long id) {
        return ResponseEntity.ok(standService.delete(id));
    }

    @GetMapping("")
    public ResponseEntity<Page<StandEntity>> getPage(
            Pageable pageable,
            @RequestParam(name = "filter", required = false) String strFilter) {
        return ResponseEntity.ok(standService.getPage(pageable, strFilter));
    }

    @PostMapping("/populate/{amount}")
    public ResponseEntity<Long> populate(@PathVariable("amount") Integer amount) {
        return ResponseEntity.ok(standService.populate(amount));
    }
 
    @DeleteMapping("/empty")
    public ResponseEntity<Long> empty() {
        return ResponseEntity.ok(standService.empty());
    }
}
