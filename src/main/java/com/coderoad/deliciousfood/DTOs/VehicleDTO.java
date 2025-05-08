package com.coderoad.deliciousfood.DTOs;

import com.coderoad.deliciousfood.models.Vehicle;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class VehicleDTO {
    private String type;
    private String plateNumber;
    public Vehicle getModel() {
        Vehicle vehicle = new Vehicle();
        vehicle.setType(this.type);
        vehicle.setPlateNumber(this.plateNumber);
        return vehicle;
    }
}
