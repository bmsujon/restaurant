package com.restaurant.restaurant.modules.customer.dto;

import com.restaurant.restaurant.common.responses.PaginationResponse;
import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerPaginationResponse extends PaginationResponse {
    private List<CustomerResponse> customers;
}
