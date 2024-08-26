package com.example._mono_fundamentals_;

import com.example._fundamental_.subscriber.SubscriberImpl;
import reactor.core.publisher.Mono;

public class MonoJust {
    public static void main(String[] args) {
        var monoPublisher = Mono.just("Devendra");
        var subscriber = new SubscriberImpl();

        monoPublisher.subscribe(subscriber);

        subscriber.getSubscription().request(3);
        subscriber.getSubscription().request(3);
        subscriber.getSubscription().cancel();

    }
}
