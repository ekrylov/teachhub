package ru.teachhub.domain.task;

import ru.teachhub.domain.Assignment;
import ru.teachhub.view.task.MultipleChoiceTaskViewBean;
import ru.teachhub.view.task.TaskViewBean;

public class MultipleChoiceTaskFactory implements TaskFactory {

    @Override
    public TaskViewBean createTaskViewBean(Assignment assignment) {
        return new MultipleChoiceTaskViewBean(assignment);
    }
    
    @Override
    public TaskAnswer createTaskAnswer(Assignment assignment) {
        return new MultipleChoiceTaskAnswer(assignment);
    }

}
