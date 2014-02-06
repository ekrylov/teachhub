package ru.teachhub.view.task;

import ru.teachhub.domain.Assignment;
import ru.teachhub.domain.Task;
import ru.teachhub.domain.TaskStatus;

public abstract class AbstractTaskViewBean implements TaskViewBean {

    private final Assignment assignment;

    public AbstractTaskViewBean(Assignment assignment) {
        this.assignment = assignment;
    }

    @Override
    public abstract String getTemplate();

    @Override
    public Assignment getAssignment() {
        return assignment;
    }

    @Override
    public Task getTask() {
        return assignment.getUnitTask().getTask();
    }

    @Override
    public void changeStatus(TaskStatus newTaskStatus) {
        TaskStatus currentTaskStatus = assignment.getTaskStatus();

        switch (newTaskStatus) {
            case RUNNING:
                if (currentTaskStatus == TaskStatus.NOT_OPENED) {
                    assignment.setTaskStatus(newTaskStatus);
                }
                break;
            default:
                break;
        }


    }

}
