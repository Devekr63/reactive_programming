package com.example._flux_fundamental_;

import com.example._flux_fundamental_.client.ExternalClientService;
import com.example.common.Util;

public class _08NonBlockingStreamingMessages {
    public static void main(String[] args) {
        var client = new ExternalClientService();

        client.getNames()
                .subscribe(Util.subscriber("subs-1"));

        client.getNames()
                .subscribe(Util.subscriber("subs-2"));

        Util.sleepSeconds(6);
    }
}
