package com.nghia.ivector.domain.order.repository;

import com.nghia.ivector.domain.order.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {
}
