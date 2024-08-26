package com.example._mono_fundamentals_;

import com.example.common.Util;
import reactor.core.publisher.Mono;

import java.util.List;

public class MonoFromSupplier {
    public static void main(String[] args) {

        var list = List.of(1,2,3);

        //from supplier is lazy and runs when a subscriber request from publisher.
        //it does not throws exception
        Mono.fromSupplier(() -> sum(list))
                .subscribe(Util.subscriber());
    }

    private static int sum(List<Integer> list){
        return list.stream().mapToInt(i -> i).sum();
    }
}
