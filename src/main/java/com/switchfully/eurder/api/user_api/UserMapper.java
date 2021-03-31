package com.switchfully.eurder.api.user_api;

import com.switchfully.eurder.domain.User;
import com.switchfully.eurder.domain.UserType;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public User toCustomer(CreateUserDto dto) {
        return new User(
                dto.getFirstName(),
                dto.getLastName(),
                dto.getAddress(),
                dto.getPhoneNumber(),
                dto.getEmailAddress(),
                UserType.CUSTOMER
        );
    }

    public UserDto toDto(User user) {
        return new UserDto()
                .setId(user.getId())
                .setFirstName(user.getFirstName())
                .setLastName(user.getLastName())
                .setAddress(user.getAddress())
                .setPhoneNumber(user.getPhoneNumber())
                .setEmailAddress(user.getEmailAddress())
                .setUserType(user.getUserType());
    }

    public List<UserDto> toDto(List<User> users) {
        return users.stream().map(this::toDto).collect(Collectors.toList());
    }

}
