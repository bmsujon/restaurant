package com.restaurant.restaurant.modules.customer.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
public class CustomerAddRequest {
    @NotBlank(message = "Name is mandatory.")
    private String name;
    @NotBlank(message = "MobileNumber is mandatory.")
    private String mobileNumber;
    private String gender;
    private String dateOfBirth;
    private String password;
    @NotBlank(message = "CustomerType is mandatory.")
    private String customerType;
}
