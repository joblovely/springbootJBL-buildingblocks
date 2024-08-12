package com.ovium.restfulservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import com.ovium.restfulservices.entities.User;
import com.ovium.restfulservices.exceptions.UserExistsException;
import com.ovium.restfulservices.exceptions.UserNotFoundException;
import com.ovium.restfulservices.services.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

@RestController
@Validated // for @min(1)
@RequestMapping(value = "/users")
@Api(tags = "Swager Annotations to User Controller Class", value = "userController")
public class UserController {

	@Autowired
	private UserService userServices;

	@GetMapping("/home")
	public void home() {

	}

	@PostMapping
	public ResponseEntity<Void> createUser(@ApiParam("New User Information") @Valid @RequestBody User user,
			UriComponentsBuilder builder) {
		try {

			userServices.createUser(user);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(builder.path("/users/{id}").buildAndExpand(user.getUserid()).toUri());
			headers.setBasicAuth("Basic Auth");
			return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
			// Note: if you want to see location go and check header Location param in
			// postman
		} catch (UserExistsException e) {
			throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, e.getMessage());
		}
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Retrieve user using Id")
	public User getUserId(@ApiParam("User ID") @PathVariable("id") @Min(1) Long id) {
		try {
			return userServices.getUserById(id).get();
		} catch (UserNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, e.getMessage());
		}
		// return null;
	}

	@ApiOperation(value = "Retrieve List of Users")
	@GetMapping
	public List<User> getAllUsers() {
		return userServices.getAllUsers();
	}

	@GetMapping("/username/{username}")
	@ApiOperation(value = "Retrieve user by user name")
	public User getUserByName(@ApiParam("UserName") @PathVariable("username") String username)
			throws UserNotFoundException {
		User user = userServices.getUserByUsername(username);
		if (user == null) {
			throw new UserNotFoundException("Username " + username + " Not found");
		}
		return user;
	}

	@PutMapping("/{id}")
	public User updateUserById(@PathVariable("id") Long id, @RequestBody User user) {
		try {
			return userServices.updateUserById(id, user);
		} catch (UserNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	@DeleteMapping("/{id}")
	public boolean deleteUserById(@PathVariable("id") Long id) {
		boolean b = userServices.deleteUserById(id);
		if (b) {
			return b;
		}
		return false;

	}
}
