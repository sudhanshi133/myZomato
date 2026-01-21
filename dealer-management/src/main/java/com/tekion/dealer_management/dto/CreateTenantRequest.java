package com.tekion.dealer_management.dto;

import com.tekion.dealer_management.model.DbType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateTenantRequest {
    public String tenantId;
    public DbType dbType;
}

