package com.example.async_client.client;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Component
public class FluxClient {
    private final WebClient webClient;

    public FluxClient(WebClient webClient){
        System.out.println("Client Created.");
        this.webClient = webClient;
    }

    public Flux<Long> getValues(){
        return webClient.get()
                .uri("/infinite-flux-stream")
                .retrieve()
                .bodyToFlux(Long.class);
    }

    public Flux<Integer> getFourValues(){
        return webClient.get()
                .uri("/fluxstream")
                .retrieve()
                .bodyToFlux(Integer.class);
    }
}