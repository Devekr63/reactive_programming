package com.example._flux_fundamental_.helper;

import com.example.common.Util;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NameGenerator {

    public List<String> namesList(int count){
        return IntStream.range(0, count)
                .mapToObj(i->getName())
                .collect(Collectors.toList());
    }

    public Flux<String> namesFlux(int count){
        return Flux.range(0, count)
                .map(i->getName());
    }

    private static String getName(){
        Util.sleepSeconds(1);
        return Util.faker().name().firstName();
    }
}
