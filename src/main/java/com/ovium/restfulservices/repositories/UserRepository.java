package com.ovium.restfulservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ovium.restfulservices.entities.User;

//Repository
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);

}
