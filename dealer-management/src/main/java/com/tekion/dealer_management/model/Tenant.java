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
@Document(collection = "tenants")
public class Tenant {
    @Id
    @Field("_id")
    private String id;
    private String dealerId;
    private DbType dbType;
    private String dbConnection;
    private Instant createdAt;

    public Tenant(String id, String dealerId, DbType dbType) {
        this.id = id;
        this.dealerId = dealerId;
        this.dbType = dbType != null ? dbType : DbType.SHARED;
        this.dbConnection = null;
        this.createdAt = Instant.now();
    }
}

