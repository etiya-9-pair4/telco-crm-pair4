package com.etiya.identityservice.service.role;

import com.etiya.identityservice.dto.Roles.request.*;
import com.etiya.identityservice.dto.Roles.response.*;
import com.etiya.identityservice.entity.Role;
import com.etiya.identityservice.mapper.RoleMapper;
import com.etiya.identityservice.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    @Override
    public CreateRoleResponseDto create(CreateRoleRequestDto createRoleRequestDto) {
        return null;
    }

    @Override
    public UpdateRoleResponseDto update(UpdateRoleRequestDto updateRoleRequestDto) {
        return null;
    }

    @Override
    public DeleteRoleResponseDto delete(DeleteRoleRequestDto deleteRoleRequestDto) {
        return null;
    }

    @Override
    public RoleResponseDto getByRoleId(RoleRequestDto roleRequestDto) {
        return null;
    }

    @Override
    public ListRoleResponseDto<ListRoleRequestDto> getAll() {
        return null;
    }

}
