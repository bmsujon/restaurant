package com.restaurant.restaurant.modules.customer;

import com.amazonaws.services.personalizeevents.model.InvalidInputException;
import com.restaurant.restaurant.common.util.MobileNumberUtil;
import com.restaurant.restaurant.modules.customer.dto.CustomerAddRequest;
import com.restaurant.restaurant.modules.customer.dto.CustomerPaginationResponse;
import com.restaurant.restaurant.modules.customer.dto.CustomerResponse;
import com.restaurant.restaurant.modules.customer.dto.CustomerType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
class CustomerService {
    private final CustomerRepository customerRepository;


    public void createCustomer(CustomerAddRequest request) {
        if(!MobileNumberUtil.isValidNumber(request.getMobileNumber())) {
            throw new InvalidInputException("Invalid mobileNumber. Please, check that it starts with +88, contains 11 digits afterwards.");
        }
        if(!isValidCustomerType(request.getCustomerType())) {
            throw new InvalidInputException("CustomerType can only be REGISTERED or UNREGISTERED");
        }
        Customer customer = Customer.builder()
                .name(request.getName())
                .customerType(CustomerType.REGISTERED.name())
                .dateOfBirth(request.getDateOfBirth())
                .mobileNumber(request.getMobileNumber())
                .gender(request.getGender())
                .password(request.getPassword())
                .build();
        log.info("Customer created : " + customer);
        customerRepository.save(customer);
    }

    public CustomerPaginationResponse getAll(Pageable pageable) {
        Page<CustomerResponse> customerPage = customerRepository.findAll(pageable);
        log.info("Got customers: " + customerPage);
        return getCustomerPaginationResponseFromPage(customerPage);
    }

    private CustomerPaginationResponse getCustomerPaginationResponseFromPage(Page<CustomerResponse> customerPage) {
        CustomerPaginationResponse response = new CustomerPaginationResponse();
        response.setCustomers(customerPage.getContent());

        response.setFirst(customerPage.isFirst());
        response.setLast(customerPage.isLast());
        response.setPageNumber(customerPage.getNumber());
        response.setNumberOfElements(customerPage.getNumberOfElements());
        response.setTotalPages(customerPage.getTotalPages());
        response.setTotalElements(customerPage.getTotalElements());
        return response;
    }

    private boolean isValidCustomerType(String customerType) {
        if(customerType != null && !customerType.isEmpty()) {
            return customerType.equals(CustomerType.REGISTERED.name()) || customerType.equals(CustomerType.UNREGISTERED.name());
        }
        return false;
    }
}
