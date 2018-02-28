package com.abrab.comptemicroservice.serviceProxy.fallback;

import com.abrab.comptemicroservice.serviceProxy.OperatrionServiceProxy;
import org.springframework.stereotype.Component;

@Component
public class OperationServiceProxyFallback implements OperatrionServiceProxy {

    @Override
    public long totalOperations(String rib) {

        System.out.println("=========================>totalOperationsFallBack");
        return -1;
    }
}
