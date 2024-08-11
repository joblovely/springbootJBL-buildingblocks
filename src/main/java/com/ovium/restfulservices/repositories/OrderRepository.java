package com.ovium.restfulservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ovium.restfulservices.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
	public Order findByIdAndUserId(long orderId, long userId);
	// Has to implement as it's an assignment.
	// https://stackoverflow.com/questions/62020299/spring-data-jpa-retrieve-data-with-multiple-pathvariable

}