package dev.layseiras.hellorecruiter.controller;

import dev.layseiras.hellorecruiter.model.TechItem;
import dev.layseiras.hellorecruiter.service.TechItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TechItemController {
    @Autowired
    private TechItemService service;

    @PostMapping("/techs")
    public ResponseEntity<TechItem> addNewTech(@RequestBody TechItem techItem) {
        TechItem add = service.addNewTech(techItem);
        return ResponseEntity.ok(add);
    }

    @GetMapping("/techs")
    public ResponseEntity<List<TechItem>> getAllTech() {
        List<TechItem> all = service.getAllTech();
        return ResponseEntity.ok(all);
    }

    @PutMapping("/techs/{id}")
    public ResponseEntity<TechItem> updateTech(@RequestBody TechItem techItem, @PathVariable Long id) {
        return service.getTechById(id)
                .map(techFound -> {
                    techItem.setId(techFound.getId());
                    TechItem updated = service.updateTech(techItem);
                    return ResponseEntity.ok(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/techs/{id}")
    public ResponseEntity<Void> deleteTech(@PathVariable Long id) {
        service.deleteTech(id);
        return ResponseEntity.noContent().build();
    }
}
