package com.etiya.identityservice.mapper;

import com.etiya.identityservice.dto.User.request.CreateUserRequestDto;
import com.etiya.identityservice.dto.User.request.DeleteUserRequestDto;
import com.etiya.identityservice.dto.User.request.ListUserRequestDto;
import com.etiya.identityservice.dto.User.request.UpdateUserRequestDto;
import com.etiya.identityservice.dto.User.response.CreateUserResponseDto;
import com.etiya.identityservice.dto.User.response.DeleteUserResponseDto;
import com.etiya.identityservice.dto.User.response.ListUserResponseDto;
import com.etiya.identityservice.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public  abstract class UserMapper {
    // create

    @Mapping(target = "title.id", source = "titleId")
    public abstract User userFromCreateRequest(CreateUserRequestDto createUserRequestDto);

    @Mapping(target = "titleId", source = "title.id")
    public abstract CreateUserResponseDto createUserResponseFromUser(User user);

    // update

    @Mapping(target = "title.id", source = "titleId")
    public abstract User userFromUpdateRequest(UpdateUserRequestDto updateUserRequestDto);

    @Mapping(target = "titleId", source = "title.id")
    public abstract UpdateUserRequestDto updateUserResponseFromUser(User user);

    // delete

    @Mapping(target = "title.id", source = "titleId")
    public abstract User userFromDeleteRequest(DeleteUserRequestDto deleteUserRequestDto);

    @Mapping(target = "titleId", source = "title.id")
    public abstract DeleteUserResponseDto deleteUserResponseFromUser(User user);

    //GetByIdUserId
    @Mapping(target="id", source = "titleId")
    public abstract User userFromListRequest(ListUserRequestDto listUserRequestDto);

    @Mapping(target="titleId", source = "title.id")
    public abstract ListUserResponseDto listUserResponseFromListUser(User user);


}
