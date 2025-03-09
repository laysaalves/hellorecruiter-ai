package dev.layseiras.hellorecruiter.controller;

import dev.layseiras.hellorecruiter.service.GepetoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class ReqController {
    private final GepetoService service;

    public ReqController(GepetoService service) {
        this.service = service;
    }

    @GetMapping("/generate")
    public Mono<ResponseEntity<String>> generateEmailBody(){
        return service.generateEmailBody()
                .map(emailBody -> ResponseEntity.ok(emailBody))
                .defaultIfEmpty(ResponseEntity.noContent().build());
    }
}
