package com.abrab.comptemicroservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

//@EnableBinding(Sink.class)
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("com.abrab.comptemicroservice.serviceProxy")
@EnableCircuitBreaker
public class CompteMicroserviceApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CompteMicroserviceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Compte-Ms Start ...");

    }
}

//@MessageEndpoint
//class CompteMessageAccepter {
//
//    public void accept(String s) {
//        System.out.println("received msg===>" + s);
//    }
//}
