package ru.teachhub.view.task;

import ru.teachhub.domain.Assignment;

public class OpenQuestionTaskViewBean extends AbstractTaskViewBean {

    public OpenQuestionTaskViewBean(Assignment assignment) {
        super(assignment);
    }

    @Override
    public String getTemplate() {
        return "open_question_task.jspx";
    }

}
