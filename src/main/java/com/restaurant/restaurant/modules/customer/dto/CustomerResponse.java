package com.restaurant.restaurant.modules.customer.dto;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponse {
    private Integer id;
    private String name;
    private String mobileNumber;
    private String gender;
    private String dateOfBirth;
    private String password;
    private String customerType;
    private Instant createdAt;
    private Instant updatedAt;
}
