package ru.teachhub.view.task;

import ru.teachhub.domain.Assignment;
import ru.teachhub.domain.Task;
import ru.teachhub.domain.task.TaskStatus;

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

        if (newTaskStatus == TaskStatus.RUNNING && currentTaskStatus == TaskStatus.NOT_OPENED) {
            assignment.setTaskStatus(newTaskStatus);
        }
    }

    @Override
    public boolean isOpenable() {
        return getAssignment().getTaskStatus() == TaskStatus.NOT_OPENED
                || getAssignment().getTaskStatus() == TaskStatus.RUNNING;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof TaskViewBean)) {
            return false;
        }

        if (this == obj) {
            return true;
        }

        TaskViewBean otherTaskViewBean = (TaskViewBean) obj;
        return getAssignment().equals(otherTaskViewBean.getAssignment());
    }

    @Override
    public int hashCode() {
        return getAssignment().hashCode();
    }

}
