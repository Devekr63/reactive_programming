package com.example.reactive_programming.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
public class FluxController {

    @GetMapping("/flux")
    public Flux<Integer> getFlux(){
        return Flux.range(0,4)
                .delayElements(Duration.ofMillis(500))
                .log();
    }

    @GetMapping(value = "/fluxstream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Integer> getFluxStream(){
        return Flux.range(0,4)
                .delayElements(Duration.ofMillis(500))
                .log();
    }

    @GetMapping(value = "/infinite-flux-stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Long> getFluxStreamInfinite(){
        return Flux.interval(Duration.ofMillis(1000))
                .log();
    }
}
