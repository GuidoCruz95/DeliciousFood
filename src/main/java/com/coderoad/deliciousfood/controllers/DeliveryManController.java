package com.coderoad.deliciousfood.controllers;

import com.coderoad.deliciousfood.DTOs.DeliveryManDTO;
import com.coderoad.deliciousfood.DTOs.VehicleDTO;
import com.coderoad.deliciousfood.models.DeliveryMan;
import com.coderoad.deliciousfood.services.DeliveryManService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/deliverymen")
public class DeliveryManController {

    private final DeliveryManService deliveryManService;

    public DeliveryManController(DeliveryManService deliveryManService) {
        this.deliveryManService = deliveryManService;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public DeliveryManDTO register(@RequestBody DeliveryManDTO deliveryManDTO) {
        DeliveryMan deliveryMan = deliveryManService.register(deliveryManDTO.getModel());
        return deliveryMan.getDTO();
    }

    @PutMapping("/updateVehicleInformation/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DeliveryManDTO updateVehicleInformation(
            @PathVariable Long id,
            @RequestBody VehicleDTO vehicleDTO) {

        DeliveryMan updatedDeliveryMan = deliveryManService.updateVehicleInformation(id, vehicleDTO.getModel());
        return updatedDeliveryMan.getDTO();
    }
}