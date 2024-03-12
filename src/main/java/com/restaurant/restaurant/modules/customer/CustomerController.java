package com.restaurant.restaurant.modules.customer;

import com.restaurant.restaurant.modules.customer.dto.CustomerAddRequest;
import com.restaurant.restaurant.modules.customer.dto.CustomerPaginationResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
@Validated
@RequiredArgsConstructor
class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<String> create(@Valid @RequestBody CustomerAddRequest request) {
        customerService.createCustomer(request);
        return new ResponseEntity<>("Customer created.", HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<CustomerPaginationResponse> getAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                         @RequestParam(value = "limit", defaultValue = "100") Integer limit) {
        CustomerPaginationResponse response = customerService.getAll(PageRequest.of(page, limit));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
