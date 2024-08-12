
package com.ovium.restfulservices.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.Mapping;

import com.ovium.restfulservices.dtos.UserMsDto;
import com.ovium.restfulservices.entities.User;

@Mapper(componentModel = "Spring")
public interface UserMapper {

	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

	// User To UserMsDto
	@Mappings({ @Mapping(source = "email", target = "emailaddress"), @Mapping(source = "role", target = "rolename") })
	UserMsDto userToUserMsDto(User user);

	// List<User> to List<UserMsDto>
	List<UserMsDto> usersToUserDtos(List<User> users);

}
