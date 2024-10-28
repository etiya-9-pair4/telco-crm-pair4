package com.etiya.identityservice.service.role;

import com.etiya.identityservice.dto.Roles.request.*;
import com.etiya.identityservice.dto.Roles.response.*;
import com.etiya.identityservice.entity.Role;

public interface RoleService {
    CreateRoleResponseDto create(CreateRoleRequestDto createRoleRequestDto);

    UpdateRoleResponseDto update(UpdateRoleRequestDto updateRoleRequestDto);

    DeleteRoleResponseDto delete(DeleteRoleRequestDto deleteRoleRequestDto);

    RoleResponseDto getByRoleId(RoleRequestDto roleRequestDto);

    ListRoleResponseDto<ListRoleRequestDto> getAll();
}
