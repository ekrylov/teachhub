package ru.teachhub.view.task;

import ru.teachhub.domain.Assignment;
import ru.teachhub.domain.Task;
import ru.teachhub.domain.task.TaskStatus;

public class OpenQuestionTaskViewBean extends AbstractTaskViewBean {

    public OpenQuestionTaskViewBean(Assignment assignment) {
        super(assignment);
    }

    @Override
    public String getTemplate() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Assignment getAssignment() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Task getTask() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void changeStatus(TaskStatus newTaskStatus) {
        // TODO Auto-generated method stub

    }

}
