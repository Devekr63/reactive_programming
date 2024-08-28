package com.example.async_client.client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FluxClientIntTest {

    @Autowired
    FluxClient fluxClient;

    @Test
    public void shouldFindAllNum(){
        Flux<Integer> flux = fluxClient.getFourValues();
        StepVerifier.create(flux)
                .expectNextCount(4)
                .verifyComplete();
    }
}
