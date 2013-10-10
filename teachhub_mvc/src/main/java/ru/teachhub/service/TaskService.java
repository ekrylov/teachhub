package ru.teachhub.service;

import java.util.List;

import ru.teachhub.domain.Task;

public interface TaskService {

    List<Task> findAll();

    List<Task> findByTitle(String title);

}
