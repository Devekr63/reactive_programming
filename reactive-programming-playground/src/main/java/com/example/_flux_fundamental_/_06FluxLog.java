package com.example._flux_fundamental_;

import com.example.common.Util;
import reactor.core.publisher.Flux;

public class _06FluxLog {
    public static void main(String[] args) {
        Flux.range(0,3)
                .log("range -> map")
                .map(i -> Util.faker().name().firstName())
                .log("map -> subscriber")
                .subscribe(Util.subscriber());
    }
}
