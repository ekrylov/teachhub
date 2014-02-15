package ru.teachhub.view.task;

import org.springframework.stereotype.Service;

import ru.teachhub.domain.Assignment;
import ru.teachhub.domain.task.TaskType;

@Service("taskViewBeanFactory")
public class TaskViewBeanFactory {

    public TaskViewBean createTaskViewBean(Assignment assignment) {
        if (assignment.getUnitTask().getTask().getTaskContent().getTaskType() == TaskType.MULTIPLE_CHOICE) {
            return new MultipleChoiceTaskViewBean(assignment);
        } else {
            return new ErrorTaskViewBean(assignment);
        }
    }

}
