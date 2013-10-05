package ru.teachhub.service;

import java.util.List;

import ru.teachhub.domain.Role;

public interface RoleService
{

    List<Role> findAll();

    List<Role> findByTitle( String title );

}
