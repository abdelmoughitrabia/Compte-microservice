package com.abrab.comptemicroservice.serviceProxy;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "operation-ms")
@RibbonClient(name = "operation-ms")
public interface OperatrionServiceProxy {

    @GetMapping("{rib}/operations/size")
    public long totalOperations(@PathVariable("rib") String rib);
}
