package ru.teachhub.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ru.teachhub.domain.Group;

public interface GroupRepository
    extends CrudRepository<Group, Long>
{

    List<Group> findByTitle( String title );

}
