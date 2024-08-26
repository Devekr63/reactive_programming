package com.example._fundamental_;

import com.example._fundamental_.publisher.PublisherImpl;
import com.example._fundamental_.subscriber.SubscriberImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Demo {
    public static void main(String[] args) {
//        demo1();
        demo2();
    }

    public static void demo1(){
        Logger logger = LoggerFactory.getLogger(Demo.class);

        var publisher = new PublisherImpl(10);
        var subscriber = new SubscriberImpl();

        publisher.subscribe(subscriber);
        for(int i=0; i<4; i++){
            if(i==2) subscriber.getSubscription().cancel(); //testing subscription canceling
            subscriber.getSubscription().request(3);
            try{
                Thread.sleep(500);
            }catch(InterruptedException ie){
               logger.error(ie.getMessage());
            }
        }
    }

    public static void demo2(){
        Logger logger = LoggerFactory.getLogger(Demo.class);

        var publisher = new PublisherImpl(10);
        var subscriber = new SubscriberImpl();

        publisher.subscribe(subscriber);
        subscriber.getSubscription().request(11);
    }
}
