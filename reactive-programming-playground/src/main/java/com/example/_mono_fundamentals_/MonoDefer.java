package com.example._mono_fundamentals_;

import com.example.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

public class MonoDefer {
    private static final Logger logger = LoggerFactory.getLogger(MonoDefer.class);

    public static void main(String[] args) {

        //*** publisher is instantly created
//        createPublisher().subscribe(Util.subscriber());

        //*** defer method delay the creating of publisher
        Mono.defer(MonoDefer::createPublisher)
                .subscribe(Util.subscriber());
    }

    private static Mono<Integer> createPublisher(){
        logger.info("creating publisher");
        var list = Arrays.asList(1,2,3,4);
        Util.sleepSeconds(1);
        return Mono.fromSupplier(() -> sum(list));
    }

    private static int sum(List<Integer> list){
        logger.info("finding the sum of list: {}", list);
        Util.sleepSeconds(3);
        return list.stream().mapToInt(i->i*i).sum();
    }
}
