package com.example._flux_fundamental_;

import com.example.common.Util;
import reactor.core.publisher.Flux;

public class _02FluxMultipleSubscriber {
    public static void main(String[] args) {
        var flux = Flux.just(1,2,3,4,5);

        flux.map(n -> n*(n-1))
                .filter(n -> n > 7)
                .subscribe(Util.subscriber());

        flux.subscribe(Util.subscriber());
    }
}
