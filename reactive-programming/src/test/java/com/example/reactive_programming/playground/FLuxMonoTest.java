package com.example.reactive_programming.playground;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class FLuxMonoTest {
    @Test
    public void fluxTest_ElementsWithoutError(){
        Flux<String> fluxString = Flux.just("Spring", "Spring Boot", "Reactive Spring")
                .log();

        StepVerifier.create(fluxString)
                .expectNext("Spring")
                .expectNext("Spring Boot")
                .expectNext("Reactive Spring")
                .verifyComplete();
    }

    @Test
    public void fluxTestElements_WithError(){
        Flux<String> fluxString = Flux.just("Spring", "Spring Boot", "Reactive Spring")
                .concatWith(Flux.error(new RuntimeException("Exception Occurred")))
                .log();

        StepVerifier.create(fluxString)
                .expectNext("Spring")
                .expectNext("Spring Boot")
                .expectNext("Reactive Spring")
//                .expectError(RuntimeException.class)
                .expectErrorMessage("Exception Occurred")
                .verify();
    }

    @Test
    public void fluxTestElementsCount_WithError(){
        Flux<String> fluxString = Flux.just("Spring", "Spring Boot", "Reactive Spring")
                .concatWith(Flux.error(new RuntimeException("Exception Occurred")))
                .log();

        StepVerifier.create(fluxString)
                .expectNextCount(3)
//                .expectError(RuntimeException.class)
                .expectErrorMessage("Exception Occurred")
                .verify();
    }
}
