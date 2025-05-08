package com.coderoad.deliciousfood.models;

import com.coderoad.deliciousfood.DTOs.VehicleDTO;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Vehicle {
    private String type;
    private String plateNumber;

    public VehicleDTO getDTO() {
        return VehicleDTO.builder()
                .type(this.type)
                .plateNumber(this.plateNumber)
                .build();
    }
}