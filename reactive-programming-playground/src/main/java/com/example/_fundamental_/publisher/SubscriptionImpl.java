package com.example._fundamental_.publisher;

import com.github.javafaker.Faker;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SubscriptionImpl implements Subscription {

    private static final Logger logger = LoggerFactory.getLogger(SubscriptionImpl.class);
    private final Subscriber<? super String> subscriber;
    private boolean isCancelled;
    private final Faker faker;
    private final int MAX_VALUE;
    private int count = 0;

    public SubscriptionImpl(Subscriber<? super String> subscriber, int value) {
        this.subscriber = subscriber;
        faker = Faker.instance();
        MAX_VALUE = value;
    }

    @Override
    public void request(long requested) {
        if(isCancelled) return;

        if(requested > MAX_VALUE){
            logger.error("Too many requested items.");
            return;
        }

        logger.info("subscriber has requested {} items", requested);

        for(int i=0; i<requested && count < MAX_VALUE; i++){
            count++;
            this.subscriber.onNext(this.faker.internet().emailAddress());
        }

        if(count == MAX_VALUE){
            logger.warn("no more data to produce.");
            this.subscriber.onComplete();
            this.isCancelled = true;
        }
    }

    @Override
    public void cancel() {
        logger.info("Subscriber has cancelled the subscription.");
        this.isCancelled = true;
    }
}
