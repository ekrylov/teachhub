package ru.teachhub.view.task;

import ru.teachhub.domain.Assignment;

public class UndefinedTaskViewBean extends AbstractTaskViewBean {

    public UndefinedTaskViewBean(Assignment assignment) {
        super(assignment);
    }

    @Override
    public String getTemplate() {
        return null;
    }

}
