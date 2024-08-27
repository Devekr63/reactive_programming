package com.example._flux_fundamental_;

import com.example._flux_fundamental_.helper.NameGenerator;
import com.example._fundamental_.subscriber.SubscriberImpl;
import com.example.common.Util;
import reactor.core.publisher.Flux;

public class _07FluxVsList {
    public static void main(String[] args) {
        var nameGenerator = new NameGenerator();
//        System.out.println(nameGenerator.namesList(5));

        nameGenerator.namesFlux(5)
                .subscribe(Util.subscriber());

        var subscriber = new SubscriberImpl();
        nameGenerator.namesFlux(10)
                .subscribe(subscriber);

        subscriber.getSubscription().request(3);
        subscriber.getSubscription().cancel();
    }
}
