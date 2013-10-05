package ru.teachhub.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ru.teachhub.domain.Role;

public interface RoleRepository
    extends CrudRepository<Role, Long>
{

    List<Role> findByTitle( String title );

}
