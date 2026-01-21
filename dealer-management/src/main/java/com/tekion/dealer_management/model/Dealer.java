package com.tekion.dealer_management.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "dealers")
public class Dealer {
    @Id
    @Field("_id")
    private String id;
    private Instant createdAt;

    public Dealer(String id) {
        this.id = id;
        this.createdAt = Instant.now();
    }
}

