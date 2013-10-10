package ru.teachhub.service.springjpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;

import ru.teachhub.domain.Task;
import ru.teachhub.repository.TaskRepository;
import ru.teachhub.service.TaskService;

@Service("springJpaTaskService")
@Repository
@Transactional
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Task> findAll() {
        return Lists.newArrayList(taskRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public List<Task> findByTitle(String title) {
        return taskRepository.findByTitle(title);
    }

}
