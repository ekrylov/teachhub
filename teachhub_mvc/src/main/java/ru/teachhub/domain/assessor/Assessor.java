package ru.teachhub.domain.assessor;

import ru.teachhub.domain.lesson.LessonStatistics;
import ru.teachhub.view.lesson.LessonViewBean;

public interface Assessor {

    LessonStatistics assessLesson(LessonViewBean lessonViewBean);

}
