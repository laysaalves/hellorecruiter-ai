package dev.layseiras.hellorecruiter.repository;

import dev.layseiras.hellorecruiter.model.TechItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechItemRepo extends JpaRepository<TechItem, Long> {
}
