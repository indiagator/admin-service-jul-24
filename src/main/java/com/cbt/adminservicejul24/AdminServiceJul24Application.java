package com.cbt.adminservicejul24;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AdminServiceJul24Application {

    public static void main(String[] args) {
        SpringApplication.run(AdminServiceJul24Application.class, args);
    }

}
