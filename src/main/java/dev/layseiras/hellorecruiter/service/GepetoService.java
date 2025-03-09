package dev.layseiras.hellorecruiter.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

@Service
public class GepetoService {

    private final WebClient webClient;
    private String apiKey = System.getenv("KEY");

    public GepetoService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<String> generateEmailBody() {
        String requisition = "Gere um corpo de email para um recrutador para quando eu envie meu curriculo de backend java!";
        Map<String, Object> requestBody = Map.of(
                "model", "gpt-4o",
                "messages", List.of(
                        Map.of("role", "system", "content", "Você é um assistente que escreve corpo de email."),
                        Map.of("role", "system", "content", requisition)
            )
        );
        return webClient.post()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + apiKey)
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(Map.class)
                .map(response -> {
                    var choices = (List<Map<String, Object>>) response.get("choices");
                    if (choices != null && !choices.isEmpty()) {
                        Map<String, Object> message = (Map<String, Object>) choices.get(0).get("message");
                        return message.get("content").toString();
                    }
                    return "Boa sorte em escrever esse email sozinho(a)!";
                });
    }
}
