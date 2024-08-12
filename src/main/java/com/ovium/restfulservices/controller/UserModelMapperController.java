package com.ovium.restfulservices.controller;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ovium.restfulservices.dtos.UserMmDto;
import com.ovium.restfulservices.entities.User;
import com.ovium.restfulservices.exceptions.UserNotFoundException;
import com.ovium.restfulservices.services.UserService;

import jakarta.validation.constraints.Min;

@RestController
@RequestMapping("/modelmapper/users")
public class UserModelMapperController {

	@Autowired
	private UserService userService;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping("/{id}")
	public UserMmDto getUserById(@PathVariable("id") @Min(1) Long id) throws UserNotFoundException {

		Optional<User> userOptional = userService.getUserById(id);

		if (!userOptional.isPresent()) {
			throw new UserNotFoundException("user not found");
		}

		User user = userOptional.get();

		UserMmDto userMmDto = modelMapper.map(user, UserMmDto.class);
		return userMmDto;

	}
}
