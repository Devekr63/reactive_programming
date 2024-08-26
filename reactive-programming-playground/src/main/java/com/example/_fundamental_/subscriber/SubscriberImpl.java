package com.example._fundamental_.subscriber;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SubscriberImpl implements Subscriber<String> {

    private static final Logger logger = LoggerFactory.getLogger(SubscriberImpl.class);
    private Subscription subscription;

    public Subscription getSubscription() {
        return subscription;
    }

    @Override
    public void onSubscribe(Subscription subscription) {
        logger.info("Subscription successful.");
        this.subscription = subscription;
    }

    @Override
    public void onNext(String email) {
        logger.info("received {}",email);
    }

    @Override
    public void onError(Throwable throwable) {
        logger.error("error",throwable);
    }

    @Override
    public void onComplete() {
        logger.info("completed!");
    }
}
