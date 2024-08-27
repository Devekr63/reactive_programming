package com.example._mono_fundamentals_._non_blocking_client;

import com.example.common.AbstractHttpClient;
import reactor.core.publisher.Mono;

public class ExternalClientService extends AbstractHttpClient {
    public Mono<String> getProductName(int productId){
        return this.httpClient.get()
                .uri("/demo01/product/"+productId)
                .responseContent()
                .asString()
                .next();
    }
}
