package com.etiya.identityservice.service.role;
import com.etiya.identityservice.dto.role.request.*;
import com.etiya.identityservice.dto.role.request.UpdateRoleRequestDto;
import com.etiya.identityservice.dto.role.response.*;
public interface RoleService {
    CreateRoleResponseDto create(CreateRoleRequestDto createRoleRequestDto);
    UpdateRoleResponseDto update(UpdateRoleRequestDto updateRoleRequestDto);
    DeleteRoleResponseDto delete(DeleteRoleRequestDto deleteRoleRequestDto);
    RoleResponseDto getByRoleId(RoleRequestDto roleRequestDto);
    ListRoleResponseDto<ListRoleRequestDto> getAll();
}
