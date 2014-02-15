package ru.teachhub.domain.task;

import org.springframework.stereotype.Service;

import ru.teachhub.domain.Assignment;

@Service("taskProvider")
public class TaskProvider {

    public TaskFactory createTaskFactory(Assignment assignment) {
        TaskType taskType = assignment.getUnitTask().getTask().getTaskContent().getTaskType();

        switch (taskType) {
            case MULTIPLE_CHOICE:
                return new MultipleChoiceTaskFactory();
            default:
                return new UndefinedTaskFactory();
        }
    }

}
