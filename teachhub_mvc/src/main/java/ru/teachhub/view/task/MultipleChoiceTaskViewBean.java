package ru.teachhub.view.task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ru.teachhub.domain.Assignment;

public class MultipleChoiceTaskViewBean extends AbstractTaskViewBean {

    private static final String OPTIONS_SEPARATOR = ",";

    public MultipleChoiceTaskViewBean(Assignment assignment) {
        super(assignment);
    }

    @Override
    public String getTemplate() {
        return "multiple_choice_task.jspx";
    }

    public List<String> getOptions() {
        return new ArrayList<String>(Arrays.asList(getAssignment().getUnitTask().getTask().getTaskContent()
                .getResponseOption().split(OPTIONS_SEPARATOR)));
    }
}
