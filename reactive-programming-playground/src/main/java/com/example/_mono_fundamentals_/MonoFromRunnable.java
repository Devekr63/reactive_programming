package com.example._mono_fundamentals_;

import com.example.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.util.Arrays;

public class MonoFromRunnable {
    private static final Logger logger = LoggerFactory.getLogger(MonoFromRunnable.class);

    public static void main(String[] args) {
        var productIds= Arrays.asList(1,2,3,4);

        productIds.forEach(id -> getProduct(id).subscribe(Util.subscriber()));
    }

    private static Mono<String> getProduct(int productId){
//        return productId == 1
//                ? Mono.fromSupplier(() -> Util.faker().commerce().productName())
//                : Mono.fromRunnable(() -> notifyBusiness(productId));

        return switch(productId){
          case 1 -> Mono.fromSupplier(() -> Util.faker().commerce().productName());
          case 2 -> Mono.fromSupplier(() -> Util.faker().commerce().productName());
          case 3 -> Mono.fromSupplier(() -> Util.faker().commerce().productName());
            default -> Mono.fromRunnable(() -> notifyBusiness(productId));
        };
    }

    private static void notifyBusiness(int productId){
        logger.info("notify business product with id {}, is urgently needed", productId);
    }
}
