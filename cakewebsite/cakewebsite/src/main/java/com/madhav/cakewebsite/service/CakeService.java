package com.madhav.cakewebsite.service;

import com.madhav.cakewebsite.model.Cake;
import com.madhav.cakewebsite.repository.CakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CakeService {

    @Autowired
    private CakeRepository cakeRepository;

    public List<Cake> getAllCakes() {
        return cakeRepository.findAll();
    }

    public boolean orderCake(Long id) {
        Optional<Cake> cakeOptional = cakeRepository.findById(id);
        if (cakeOptional.isPresent()) {
            // Perform any additional logic needed for ordering
            return true;
        } else {
            return false;
        }
    }
}

