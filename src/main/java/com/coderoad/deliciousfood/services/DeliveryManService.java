package com.coderoad.deliciousfood.services;

import com.coderoad.deliciousfood.models.DeliveryMan;
import com.coderoad.deliciousfood.models.Vehicle;
import com.coderoad.deliciousfood.repositories.DeliveryManRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class for handling operations related to DeliveryMan entities.
 */
@Service
public class DeliveryManService {

    private final DeliveryManRepository deliveryManRepository;

    /**
     * Constructor for injecting the DeliveryManRepository.
     *
     * @param deliveryManRepository the repository to be injected
     */
    public DeliveryManService(DeliveryManRepository deliveryManRepository) {
        this.deliveryManRepository = deliveryManRepository;
    }

    /**
     * Registers a new DeliveryMan in the system.
     *
     * @param deliveryMan the DeliveryMan to be registered
     * @return the saved DeliveryMan entity
     */
    public DeliveryMan register(DeliveryMan deliveryMan) {
        return deliveryManRepository.save(deliveryMan);
    }

    /**
     * Retrieves a DeliveryMan by their Facebook ID.
     *
     * @param facebookId the Facebook ID of the delivery man
     * @return an Optional containing the DeliveryMan if found, otherwise empty
     */
    public Optional<DeliveryMan> getByFacebookId(String facebookId) {
        return deliveryManRepository.findByFacebookId(facebookId);
    }

    /**
     * Retrieves all DeliveryMan entities from the database.
     *
     * @return a list of all DeliveryMan entities
     */
    public List<DeliveryMan> getAll() {
        return deliveryManRepository.findAll();
    }

    /**
     * Updates the vehicle information of a DeliveryMan.
     *
     * @param id      the ID of the DeliveryMan
     * @param vehicle the new vehicle information to be updated
     * @return the updated DeliveryMan entity
     * @throws RuntimeException if the DeliveryMan is not found
     */
    public DeliveryMan updateVehicleInformation(Long id, Vehicle vehicle) {
        DeliveryMan deliveryMan = deliveryManRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("DeliveryMan not found"));

        Vehicle existingVehicle = deliveryMan.getVehicle();
        existingVehicle.setType(vehicle.getType());
        existingVehicle.setPlateNumber(vehicle.getPlateNumber());

        deliveryMan.setVehicle(existingVehicle);
        return deliveryManRepository.save(deliveryMan);
    }
}
