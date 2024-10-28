package com.etiya.identityservice.service.userRole;

import java.util.List;

public interface UserRoleService {
    //TODO: user dtos!
    UserRoleService create(UserRoleService userRoleService);

    UserRoleService update(UserRoleService userRoleService);

    UserRoleService delete(UserRoleService userRoleService);

    UserRoleService getById(UserRoleService userRoleService);

    List<UserRoleService> getAll();

}
