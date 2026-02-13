package edu.ijse.gdse71.orderservice.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @Bean
    @LoadBalanced   //can call service from host name with this.
//  http://localhost:8080/api/v1/inventory/details
//  http://inventory-service/api/v1/inventory/details
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
