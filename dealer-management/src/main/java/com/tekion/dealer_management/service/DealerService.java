package com.tekion.dealer_management.service;

import com.tekion.dealer_management.model.Dealer;
import com.tekion.dealer_management.repository.DealerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DealerService {
    
    @Autowired
    private DealerRepository dealerRepository;

    public Dealer createDealer(String dealerId) {
        if (dealerRepository.existsById(dealerId)) {
            throw new IllegalArgumentException("Dealer with ID '" + dealerId + "' already exists");
        }
        Dealer dealer = new Dealer(dealerId);
        return dealerRepository.save(dealer);
    }
    
    public Dealer getDealer(String dealerId) {
        return dealerRepository.findById(dealerId)
                .orElseThrow(() -> new IllegalArgumentException("Dealer with ID '" + dealerId + "' not found"));
    }

    public boolean dealerExists(String dealerId) {
        return dealerRepository.existsById(dealerId);
    }
}

