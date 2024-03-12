package com.restaurant.restaurant.modules.customer.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
public class CustomerAddRequest {
    private String name;
    private String mobileNumber;
    private String gender;
    private String dateOfBirth;
    private String password;
    private String customerType;
}
