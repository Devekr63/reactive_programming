package com.example._mono_fundamentals_;

import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

public class MonoSubscribe {
    public static void main(String[] args) {

        var logger = LoggerFactory.getLogger(MonoSubscribe.class);

        var mono = Mono.just("Devendra").map(name -> name+" Kumar");

        mono.subscribe(
                name -> logger.info("received {}",name),
                err -> logger.error("error", err),
                () -> logger.info("completed."),
                subscription -> subscription.request(1)
        );

        var mono2 = Mono.just(1).map(i -> i/0);

        mono2.subscribe(
                num -> logger.info("received {}",num),
                err -> logger.error("error: ", err),
                () -> logger.info("completed."),
                subscription -> subscription.request(1)
        );
    }
}
