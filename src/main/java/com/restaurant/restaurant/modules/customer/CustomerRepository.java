package com.restaurant.restaurant.modules.customer;

import com.restaurant.restaurant.modules.customer.dto.CustomerResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface CustomerRepository extends ListCrudRepository<Customer, Integer> {

    Page<CustomerResponse> findAll(Pageable pageable);
}
