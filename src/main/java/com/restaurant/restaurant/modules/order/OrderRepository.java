package com.restaurant.restaurant.modules.order;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface OrderRepository  extends ListCrudRepository<Order, Integer> {
}
