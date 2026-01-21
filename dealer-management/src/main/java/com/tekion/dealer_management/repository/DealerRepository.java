package com.tekion.dealer_management.repository;

import com.tekion.dealer_management.model.Dealer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DealerRepository extends MongoRepository<Dealer, String> {
}

