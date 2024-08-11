package com.ovium.restfulservices.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ovium.restfulservices.entities.Order;
import com.ovium.restfulservices.entities.User;
import com.ovium.restfulservices.exceptions.UserNotFoundException;
import com.ovium.restfulservices.repositories.OrderRepository;
import com.ovium.restfulservices.repositories.UserRepository;

@RestController
@RequestMapping(value = "/users")
public class OrderController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;

	// get All Orders for a user

	@GetMapping("/{userid}/orders")
	public List<Order> getAllOrders(@PathVariable Long userid) throws UserNotFoundException {

		Optional<User> userOptional = userRepository.findById(userid);
		if (!userOptional.isPresent()) {
			throw new UserNotFoundException("User Not Found");
		}

		return userOptional.get().getOrders();
	}

	/*
	 * // TBD for Assignment
	 * 
	 * @GetMapping("/{userId}/orders/{orderId}") public List<Order>
	 * findAll(@PathVariable Long userId, @PathVariable Long orderId) throws
	 * UserNotFoundException{ //your code }
	 */

//	@GetMapping("/{userId}/orders/{orderId}")
//	public List<Order> findAll(@PathVariable Long userId, @PathVariable Long orderId) throws UserNotFoundException {
//		Optional<User> existingUser = this.userRepository.findByIdAndUserId(id, id);
//
//		if (existingUser.isEmpty()) {
//			throw new UserNotFoundException("User not found");
//		}
//
//		return existingUser.get().getOrders();
//
//	}

	// Create Order

	@PostMapping("{userid}/orders")
	public Order createOrder(@PathVariable Long userid, @RequestBody Order order) throws UserNotFoundException {
		Optional<User> userOptional = userRepository.findById(userid);

		if (!userOptional.isPresent()) {
			throw new UserNotFoundException("User Not Found");
		}

		User user = userOptional.get();
		order.setUser(user);
		return orderRepository.save(order);

	}

}