package ru.teachhub.view.task;

import ru.teachhub.domain.Assignment;

public class ErrorTaskViewBean extends AbstractTaskViewBean {

    public ErrorTaskViewBean(Assignment assignment) {
        super(assignment);
    }

    @Override
    public String getTemplate() {
        return "error_task.jspx";
    }

}
