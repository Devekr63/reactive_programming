package com.example._flux_fundamental_;

import com.example.common.Util;
import reactor.core.publisher.Flux;

public class _01FluxJust {
    public static void main(String[] args) {
        Flux.just(1, 2, 3, "dev")
                .subscribe(Util.subscriber());
    }
}
