package com.coderoad.deliciousfood.repositories;

import com.coderoad.deliciousfood.models.DeliveryMan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DeliveryManRepository extends JpaRepository<DeliveryMan, Long> {
    Optional<DeliveryMan> findByFacebookId(String facebookId);
}