package com.example._mono_fundamentals_;

import com.example._mono_fundamentals_._non_blocking_client.ExternalClientService;
import com.example.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MonoNonBlockingIO {
    private static final Logger logger = LoggerFactory.getLogger(MonoNonBlockingIO.class);

    public static void main(String[] args) {
        var client = new ExternalClientService();

        //Request is send and thread does not wait for the Response
        for(int i=1; i<=5; i++){
            client.getProductName(i)
                    .subscribe(Util.subscriber());
        }

        logger.info("Fetching product details");
        Util.sleepSeconds(5);
    }
}
