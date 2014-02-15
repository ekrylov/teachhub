package ru.teachhub.domain.task;

import ru.teachhub.domain.Assignment;

public class OpenQuestionTaskAnswer implements TaskAnswer {

    private final Assignment assignment;

    public OpenQuestionTaskAnswer(Assignment assignment) {
        this.assignment = assignment;
    }

    public Assignment getAssignment() {
        return assignment;
    }

}
