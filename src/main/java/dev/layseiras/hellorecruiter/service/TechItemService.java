package dev.layseiras.hellorecruiter.service;

import dev.layseiras.hellorecruiter.model.TechItem;
import dev.layseiras.hellorecruiter.repository.TechItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TechItemService {
    @Autowired
    private TechItemRepo repository;

    public TechItem addNewTech(TechItem techItem) {
        return repository.save(techItem);
    }

    public List<TechItem> getAllTech() {
        return repository.findAll();
    }

    public Optional<TechItem> getTechById(Long id) {
        return repository.findById(id);
    }

    public TechItem updateTech(TechItem techItem) {
        return repository.save(techItem);
    }

    public void deleteTech(Long id) {
        repository.deleteById(id);
    }
}
