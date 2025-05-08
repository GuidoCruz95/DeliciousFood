package com.coderoad.deliciousfood.DTOs;

import com.coderoad.deliciousfood.models.BillingInfo;
import com.coderoad.deliciousfood.models.User;
import lombok.Data;

@Data
public class UserDTO {
    private String name;
    private String email;
    private String cellphone;
    private String address;
    private String facebookId;

    public User getUser() {
        User user = new User();
        user.setName(this.name);
        user.setEmail(this.email);
        user.setAddress(this.address);
        user.setCellphone(this.cellphone);
        user.setFacebookId(this.facebookId);
        return user;
    }
}