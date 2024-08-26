package com.example._fundamental_.publisher;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public class PublisherImpl implements Publisher<String> {
    private final int MAX_VALUE;

    public PublisherImpl(int MAX_VALUE) {
        this.MAX_VALUE = MAX_VALUE;
    }

    @Override
    public void subscribe(Subscriber<? super String> subscriber) {
        var subscription = new SubscriptionImpl(subscriber, MAX_VALUE);
        subscriber.onSubscribe(subscription);
    }
}
