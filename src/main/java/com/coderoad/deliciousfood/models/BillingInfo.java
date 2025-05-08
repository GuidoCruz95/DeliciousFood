package com.coderoad.deliciousfood.models;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class BillingInfo {
    private String taxId;
    private String billingAddress;
    private String paymentMethod;
}