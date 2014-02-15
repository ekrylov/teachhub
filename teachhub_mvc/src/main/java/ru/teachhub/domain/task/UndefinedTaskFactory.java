package ru.teachhub.domain.task;

import ru.teachhub.domain.Assignment;
import ru.teachhub.view.task.TaskViewBean;
import ru.teachhub.view.task.UndefinedTaskViewBean;

public class UndefinedTaskFactory implements TaskFactory {

    @Override
    public TaskViewBean createTaskViewBean(Assignment assignment) {
        return new UndefinedTaskViewBean(assignment);
    }

    @Override
    public TaskAnswer createTaskAnswer(Assignment assignment) {
        // TODO Auto-generated method stub
        return null;
    }

}
