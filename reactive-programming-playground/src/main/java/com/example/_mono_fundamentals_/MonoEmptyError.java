package com.example._mono_fundamentals_;

import com.example.common.Util;
import reactor.core.publisher.Mono;

public class MonoEmptyError {
    public static void main(String[] args) {
        getUserName(1).subscribe(Util.subscriber());

        getUserName(2).subscribe(Util.subscriber());

        getUserName(3).subscribe(
                System.out::println,
                Throwable::printStackTrace
        );
    }

    private static Mono<String> getUserName(int userId){
        return switch(userId){
            case 1 -> Mono.just("Dev");
            case 2 -> Mono.empty();
            default -> Mono.error(new RuntimeException("Invalid userId"));
        };
    }
}
