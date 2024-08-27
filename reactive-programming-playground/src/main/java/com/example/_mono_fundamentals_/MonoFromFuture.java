package com.example._mono_fundamentals_;

import com.example.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

public class MonoFromFuture {
    private static final Logger logger = LoggerFactory.getLogger(MonoFromFuture.class);

    public static void main(String[] args) {
//        Mono.fromFuture(getName());

//        Mono.fromFuture(getName())
//                .subscribe(Util.subscriber());

        Mono.fromFuture(MonoFromFuture::getName)
                        .subscribe(Util.subscriber());

        Util.sleepSeconds(1);
    }

    private static CompletableFuture<String> getName(){
        return CompletableFuture.supplyAsync(() -> {
            logger.info("generating names.");
            return Util.faker().name().firstName();
        });
    }
}
