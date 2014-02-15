package ru.teachhub.domain.task;

import ru.teachhub.domain.Assignment;

public class MultipleChoiceTaskAnswer implements TaskAnswer {

    private final Assignment assignment;

    public MultipleChoiceTaskAnswer(Assignment assignment) {
        this.assignment = assignment;
    }

    public Assignment getAssignment() {
        return assignment;
    }

}
