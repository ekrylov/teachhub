package ru.teachhub.service;

import java.util.List;

import ru.teachhub.domain.Group;

public interface GroupService {

    List<Group> findAll();

    List<Group> findByTitle(String title);

}
