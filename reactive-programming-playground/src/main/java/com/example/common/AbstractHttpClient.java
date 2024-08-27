package com.example.common;

import reactor.netty.resources.LoopResources;
import reactor.netty.http.client.HttpClient;

public class AbstractHttpClient {
    private static final String BASE_URL = "http://localhost:7070";
    protected final HttpClient httpClient;

    public AbstractHttpClient(){
        var loopResources = LoopResources.create("dev", 1, true);
        this.httpClient = HttpClient.create().runOn(loopResources).baseUrl(BASE_URL);
    }
}
