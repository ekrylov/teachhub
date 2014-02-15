package ru.teachhub.domain.task;

import ru.teachhub.domain.Assignment;
import ru.teachhub.view.task.OpenQuestionTaskViewBean;
import ru.teachhub.view.task.TaskViewBean;

public class OpenQuestionTaskFactory implements TaskFactory {

    @Override
    public TaskViewBean createTaskViewBean(Assignment assignment) {
        return new OpenQuestionTaskViewBean(assignment);
    }

    @Override
    public TaskAnswer createTaskAnswer(Assignment assignment) {
        return new OpenQuestionTaskAnswer(assignment);
    }

}
