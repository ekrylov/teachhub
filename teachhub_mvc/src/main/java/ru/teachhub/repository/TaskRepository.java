package ru.teachhub.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ru.teachhub.domain.Task;

public interface TaskRepository extends CrudRepository<Task, Long> {

    List<Task> findByTitle(String title);

}
