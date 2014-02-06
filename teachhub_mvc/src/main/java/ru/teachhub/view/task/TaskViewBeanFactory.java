package ru.teachhub.view.task;

import ru.teachhub.domain.Assignment;

public class TaskViewBeanFactory {

    public static TaskViewBean createTaskViewBean(Assignment assignment) {
        switch (assignment.getUnitTask().getTask().getTaskContent().getTaskType()) {
            case MULTIPLE_CHOICE:
                return new MultipleChoiceTaskViewBean(assignment);
            default:
                return new ErrorTaskViewBean(assignment);
        }
    }

}
