package edu.ijse.gdse71.orderservice.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/details")
    public ResponseEntity<?> getDetails() {
        return new ResponseEntity<>("Order service is UP!", HttpStatus.OK);
    }

    @GetMapping("/health")
    public ResponseEntity<?> getHealth() {
        return new ResponseEntity<>("Order service is healthy!", HttpStatus.OK);
    }

    @GetMapping("/call-inventory")
    public ResponseEntity<?> callInventoryService() {
        String URL = "http://inventory-service/api/v1/inventory/details";
        String response = restTemplate.getForObject(URL, String.class);

        System.out.println("Inventory res: " + response);
        return new ResponseEntity<>("Order service is calling to Inventory Service success, Res: " + response, HttpStatus.OK);
    }

}
