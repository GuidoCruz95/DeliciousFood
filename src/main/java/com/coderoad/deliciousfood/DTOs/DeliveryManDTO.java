package com.coderoad.deliciousfood.DTOs;

import com.coderoad.deliciousfood.models.DeliveryMan;
import com.coderoad.deliciousfood.models.Vehicle;
import lombok.Data;

@Data
public class DeliveryManDTO {

    private String name;
    private String address;
    private String cellphone;
    private String facebookId;
    private VehicleDTO vehicleInfo;

    public DeliveryMan getModel() {
        DeliveryMan deliveryMan = new DeliveryMan();
        deliveryMan.setName(this.name);
        deliveryMan.setAddress(this.address);
        deliveryMan.setCellphone(this.cellphone);
        deliveryMan.setFacebookId(this.facebookId);

        if (this.vehicleInfo != null) {
            deliveryMan.setVehicle(this.vehicleInfo.getModel());
        }

        return deliveryMan;
    }
}