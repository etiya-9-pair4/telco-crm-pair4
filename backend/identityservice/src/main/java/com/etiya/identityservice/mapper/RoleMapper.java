package com.etiya.identityservice.mapper;
import com.etiya.identityservice.dto.role.request.RoleRequestDto;
import com.etiya.identityservice.dto.role.response.RoleResponseDto;
import com.etiya.identityservice.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
@Mapper
public interface RoleMapper {
    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);
    // RoleRequestDto -> Role (Create/Update)
    @Mapping(target="id", ignore=true) // id genellikle create işleminde veritabanında otomatik oluşur
    Role toRole(RoleRequestDto roleRequestDto);
    // Role -> RoleResponseDto (Retrieve)
    RoleResponseDto toRoleResponseDto(Role role);
}
