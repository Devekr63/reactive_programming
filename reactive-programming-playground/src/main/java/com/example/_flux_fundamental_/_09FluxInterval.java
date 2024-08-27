package com.example._flux_fundamental_;

import com.example.common.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class _09FluxInterval {
    public static void main(String[] args) {
        Flux.interval(Duration.ofMillis(500))
                .map(i-> Util.faker().name().firstName())
                .subscribe(Util.subscriber());

        Util.sleepSeconds(5);

    }
}
