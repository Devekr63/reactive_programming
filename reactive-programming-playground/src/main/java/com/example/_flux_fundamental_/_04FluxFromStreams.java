package com.example._flux_fundamental_;

import com.example.common.Util;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Stream;

public class _04FluxFromStreams {
    public static void main(String[] args) {

        //since stream are only for one use we cannot use for two different subscriber
//        var flux = Flux.fromStream(Stream.of(1,2,3,4));
//
//        flux.subscribe(Util.subscriber("subs 1"));
//        flux.subscribe(Util.subscriber("subs 2"));

        var list = List.of(1,2,3,4);
        var flux = Flux.fromStream(list::stream);

        flux.subscribe(Util.subscriber("subs 1"));
        flux.subscribe(Util.subscriber("subs 2"));

    }
}
