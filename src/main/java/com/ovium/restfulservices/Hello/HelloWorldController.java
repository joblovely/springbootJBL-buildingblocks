package com.ovium.restfulservices.Hello;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	// @RequestMapping(method = RequestMethod.GET, path = "/helloworld")
	@GetMapping("/helloworld")
	public String helloWorld() {
		return "Hello World Lovely P Job";
	}

	@GetMapping("/helloworld-bean")
	public UserDetails helloWorldBean() {
		return new UserDetails("Kalyan", "Reddy", "Hyderabad");

	}

	@GetMapping("/helloworld-beans")
	public List<UserDetails> helloworldBeans() {
		List<UserDetails> contacts = new ArrayList<UserDetails>();
		UserDetails objt1 = new UserDetails("Hyundai", "Santra", "Kochi");
		UserDetails objt2 = new UserDetails("Lovely", "Job", "Chicago");
		UserDetails objt3 = new UserDetails("Fancy", "Lovely", "Chicago");
		contacts.add(objt3);
		contacts.add(objt2);
		contacts.add(objt1);

		/*
		 * ArrayList<UserDetails> userList = new ArrayList<>(); UserDetails emp1 = new
		 * UserDetails("Joel", "Lovely", "USA Chicago"); // adding the objects into
		 * ArrayList userList.add(emp1);
		 */

		return contacts;
	}
}
