package edu.ijse.gdse71.orderservice.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {
    @GetMapping("/details")
    public ResponseEntity<?> getDetails() {
        return new ResponseEntity<>("Order service is UP", HttpStatus.OK);
    }

    @GetMapping("/health")
    public ResponseEntity<?> getHealth() {
        return new ResponseEntity<>("Health service is UP", HttpStatus.OK);
    }
}
