package com.ovium.restfulservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ovium.restfulservices.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}