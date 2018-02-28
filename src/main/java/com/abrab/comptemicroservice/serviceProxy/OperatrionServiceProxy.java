package com.abrab.comptemicroservice.serviceProxy;

import com.abrab.comptemicroservice.serviceProxy.fallback.OperationServiceProxyFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Primary
@FeignClient(name = "operation-ms", fallback = OperationServiceProxyFallback.class)
@RibbonClient(name = "operation-ms")
public interface OperatrionServiceProxy {

    @GetMapping("{rib}/operations/size")
    long totalOperations(@PathVariable("rib") String rib);
}
