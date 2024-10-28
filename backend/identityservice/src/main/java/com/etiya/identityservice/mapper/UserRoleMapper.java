package com.etiya.identityservice.mapper;

import com.etiya.identityservice.dto.UserRole.request.CreateUserRoleRequestDto;
import com.etiya.identityservice.dto.UserRole.request.DeleteUserRoleRequestDto;
import com.etiya.identityservice.dto.UserRole.request.ListUserRoleRequestDto;
import com.etiya.identityservice.dto.UserRole.request.UpdateUserRoleRequestDto;
import com.etiya.identityservice.dto.UserRole.response.CreateUserRoleResponseDto;
import com.etiya.identityservice.dto.UserRole.response.DeleteUserRoleResponseDto;
import com.etiya.identityservice.dto.UserRole.response.ListUserRoleResponseDto;
import com.etiya.identityservice.dto.UserRole.response.UpdateUserRoleResponseDto;
import com.etiya.identityservice.entity.UserRole;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public  abstract class UserRoleMapper {
    //create
    @Mapping(target = "role.id", source = "roleId")
    @Mapping(target = "user.id", source = "userId")
    public abstract UserRole userRoleFromCreateRequest(CreateUserRoleRequestDto createUserRoleRequestDto);
    @Mapping(target = "roleId", source = "role.id")
    @Mapping(target = "userId", source = "user.id")
    public abstract CreateUserRoleResponseDto userRoleCreateResponseFromUserRole(UserRole userRole);

    //update
    @Mapping(target = "role.id", source = "roleId")
    @Mapping(target = "user.id", source = "userId")
    public abstract UserRole userRoleFromUpdateRequest(UpdateUserRoleRequestDto updateUserRoleRequestDto);
    @Mapping(target = "roleId", source = "role.id")
    @Mapping(target = "userId", source = "user.id")
    public abstract UpdateUserRoleResponseDto userRoleUpdateResponseFromUserRole(UserRole userRole);

    //delete
    @Mapping(target = "role.id", source = "roleId")
    @Mapping(target = "user.id", source = "userId")
    public abstract UserRole userRoleFromDeleteRequest(DeleteUserRoleRequestDto deleteUserRoleRequestDto);
    @Mapping(target = "roleId", source = "role.id")
    @Mapping(target = "userId", source = "user.id")
    public abstract DeleteUserRoleResponseDto userRoleDeleteResponseFromUserRole(UserRole userRole);

    //GetByUserRoleId
    @Mapping(target="id", source = "userRoleId")
    public abstract UserRole userRoleFromListRequest(ListUserRoleRequestDto listUserRoleRequestDto);
    @Mapping(target="roleId", source = "id")
    @Mapping(target="userId", source = "user.id")
    public abstract ListUserRoleResponseDto userRoleResponseFromListUserRole(UserRole userRole);

}
