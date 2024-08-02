package com.cbt.adminservicejul24;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/api/v1")
public class MainRestController {

    private final Logger logger = LoggerFactory.getLogger(MainRestController.class);


    @Autowired
    WebClient.Builder webClientBuilder;

    @Value("${spring.application.name}")
    public String spring_application_name;

    @Value("${gateway-server.hostname}")
    public String gateway_server_hostname;

    @GetMapping("/get/response/from/auth-service")
    public ResponseEntity<String> composeResponseWithAuthService()
    {
        logger.info("Request forwarded to Auth-Service");

        String response = webClientBuilder.build().get().uri("http://"+gateway_server_hostname+":8072/auth-service/api/v1/get/response/for/auth-service").
                retrieve().bodyToMono(String.class).block(); // SYNCHRONOUS

        return ResponseEntity.ok("Hello from " + spring_application_name+" | "+response);
    }

}
