package com.coderoad.deliciousfood.models;

import com.coderoad.deliciousfood.DTOs.DeliveryManDTO;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class DeliveryMan {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String address;
    private String cellphone;

    private String facebookId;

    @Embedded
    private Vehicle vehicle;

    @OneToMany(mappedBy = "deliveryMan")
    private List<Order> deliveries;

    public DeliveryManDTO getDTO() {
        DeliveryManDTO dto = new DeliveryManDTO();
        dto.setName(this.name);
        dto.setAddress(this.address);
        dto.setCellphone(this.cellphone);
        dto.setFacebookId(this.facebookId);

        if (this.vehicle != null) {
            dto.setVehicleInfo(this.vehicle.getDTO());
        }

        return dto;
    }
}