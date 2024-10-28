package com.etiya.identityservice.service.user;

import com.etiya.identityservice.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    //TODO: user dtos!
    User create(User createUserResponseDto);

    User update(User user);

    User delete(User user);

    User getById(User user);

    List<User> getAll();



}
