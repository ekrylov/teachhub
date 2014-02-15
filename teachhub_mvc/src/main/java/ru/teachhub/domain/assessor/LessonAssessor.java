package ru.teachhub.domain.assessor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.teachhub.domain.Assignment;
import ru.teachhub.domain.lesson.LessonStatistics;
import ru.teachhub.domain.task.TaskStatus;
import ru.teachhub.view.lesson.LessonViewBean;
import ru.teachhub.view.task.TaskViewBean;

public class LessonAssessor implements Assessor {

    private static final Logger LOG = LoggerFactory.getLogger(LessonAssessor.class);

    @Override
    public LessonStatistics assessLesson(LessonViewBean lessonViewBean) {
        LessonStatistics lessonStatistics = new LessonStatistics();

        int maxPoints = 0;
        int currentPoints = 0;

        for (TaskViewBean taskViewBean : lessonViewBean.getTaskViewBeans()) {
            Assignment assignment = taskViewBean.getAssignment();
            TaskStatus taskStatus = assignment.getTaskStatus();

            if (taskStatus == TaskStatus.NOT_DEFINED) {
                LOG.warn("There is 'NOT DEFINED' task, do not handle it");
                continue;
            }

            lessonStatistics.updateStatistics(taskStatus);

            int point = assignment.getUnitTask().getTask().getTaskContent().getPoint();
            if (taskStatus == TaskStatus.RATED) {
                currentPoints += assignment.getMark();
            }

            maxPoints += point;
        }

        lessonStatistics.setMaxPoints(maxPoints);
        lessonStatistics.setCurrentPoints(currentPoints);

        return lessonStatistics;
    }

}
