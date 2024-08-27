package com.example._flux_fundamental_;

import com.example.common.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class _10FluxMono {
    public static void main(String[] args) {
        //Mono to flux
        var mono = getUser(1);
        save(Flux.from(mono));

        //Flux to Mono
        var flux = Flux.range(1, 10);
        flux.next().subscribe(Util.subscriber());
        Mono.from(flux).subscribe(Util.subscriber());
    }

    private static Mono<String> getUser(int id){
        return switch (id){
          case 1 -> Mono.just("Dev");
          case 2 -> Mono.empty();
            default -> Mono.error(new RuntimeException("Invalid Id"));
        };
    }

    private static void save(Flux<String> flux){
        flux.subscribe(Util.subscriber());
    }
}
