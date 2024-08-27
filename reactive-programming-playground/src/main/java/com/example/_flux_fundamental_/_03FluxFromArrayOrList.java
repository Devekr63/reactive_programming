package com.example._flux_fundamental_;

import com.example.common.Util;
import reactor.core.publisher.Flux;

import java.util.List;

public class _03FluxFromArrayOrList {
    public static void main(String[] args) {
        var list = List.of(1,2,3,4,5);
        Flux.fromIterable(list)
                .subscribe(Util.subscriber());

        Integer[] arr = {1,2,3,4,5};
        Flux.fromArray(arr)
                .subscribe(Util.subscriber());
    }
}
