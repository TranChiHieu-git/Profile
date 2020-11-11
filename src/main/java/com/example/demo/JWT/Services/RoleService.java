package com.example.demo.JWT.Services;

import com.example.demo.JWT.Modals.Role;

public interface RoleService {
    Role findRoleByName(String roleName);

    Iterable<Role> findAll();

    void save(Role role);
}
