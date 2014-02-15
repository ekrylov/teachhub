package ru.teachhub.domain.task;

import ru.teachhub.domain.Assignment;
import ru.teachhub.view.task.TaskViewBean;

public interface TaskFactory {

    TaskViewBean createTaskViewBean(Assignment assignment);
    
    TaskAnswer createTaskAnswer(Assignment assignment);

}
