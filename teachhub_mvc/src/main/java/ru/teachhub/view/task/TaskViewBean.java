package ru.teachhub.view.task;

import ru.teachhub.domain.Assignment;
import ru.teachhub.domain.Task;
import ru.teachhub.domain.task.TaskStatus;

public interface TaskViewBean {

    String getTemplate();

    Assignment getAssignment();

    Task getTask();

    void changeStatus(TaskStatus newTaskStatus);
    
    boolean isOpenable();

}
