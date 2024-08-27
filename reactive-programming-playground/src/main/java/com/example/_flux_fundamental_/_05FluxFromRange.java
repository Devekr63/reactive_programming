package com.example._flux_fundamental_;

import com.example.common.Util;
import reactor.core.publisher.Flux;

public class _05FluxFromRange {
    public static void main(String[] args) {
        Flux.range(1, 10).subscribe(Util.subscriber());
        Flux.range(0,10)
                .map(i -> Util.faker().name().firstName())
                .subscribe(Util.subscriber());
//        Util.faker().name().firstName()
    }
}