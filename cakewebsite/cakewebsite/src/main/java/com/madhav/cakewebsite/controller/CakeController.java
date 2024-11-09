package com.madhav.cakewebsite.controller;

import com.madhav.cakewebsite.model.Cake;
import com.madhav.cakewebsite.service.CakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cakes")
public class CakeController {

    @Autowired
    private CakeService cakeService;

    @GetMapping
    public List<Cake> getAllCakes() {
        return cakeService.getAllCakes();
    }

    @PostMapping("/order/{id}")
    public ResponseEntity<String> orderCake(@PathVariable Long id) {
        boolean ordered = cakeService.orderCake(id);
        if (ordered) {
            return ResponseEntity.ok("Cake ordered successfully!");
        } else {
            return ResponseEntity.badRequest().body("Failed to order cake.");
        }
    }
}
