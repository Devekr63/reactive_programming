package com.example._mono_fundamentals_;

import com.example.common.Util;
import reactor.core.publisher.Mono;

import java.util.List;

public class MonoFromCallable {
    public static void main(String[] args) {

        var list = List.of(1,2,3);

        //it throws exception
        Mono.fromCallable(() -> sum(list))
                .subscribe(Util.subscriber());
    }

    private static int sum(List<Integer> list) throws Exception{
        return list.stream().mapToInt(i -> i).sum();
    }
}
