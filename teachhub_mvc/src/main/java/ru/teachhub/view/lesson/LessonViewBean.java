package ru.teachhub.view.lesson;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import ru.teachhub.domain.LessonStatus;
import ru.teachhub.domain.assessor.Assessable;
import ru.teachhub.domain.assessor.Assessor;
import ru.teachhub.domain.assessor.LessonAssessor;
import ru.teachhub.domain.lesson.LessonStatistics;
import ru.teachhub.view.task.TaskViewBean;

/**
 * Presentation of a single lesson
 * 
 * @author ekrylov
 * 
 */
public class LessonViewBean implements Assessable {

    private final List<TaskViewBean> taskViewBeans = new ArrayList<>();

    /**
     * The status of the lesson (base on the status its tasks)
     */
    private LessonStatus lessonStatus;

    /**
     * The title of the lesson
     */
    private String title;

    /**
     * The description of the lesson
     */
    private String description;

    /**
     * Unit id
     */
    private Long id;

    private LessonStatistics lessonStatistics;

    public LessonViewBean(Long id) {
        this.id = id;
    }

    public LessonViewBean(Long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public List<TaskViewBean> getTaskViewBeans() {
        return taskViewBeans;
    }

    public void addTaskViewBean(TaskViewBean taskViewBean) {
        taskViewBeans.add(taskViewBean);
    }

    public void addTaskViewBeans(Collection<TaskViewBean> taskViewBeans) {
        this.taskViewBeans.addAll(taskViewBeans);
    }

    public LessonStatus getLessonStatus() {
        return lessonStatus;
    }

    public void setLessonStatus(LessonStatus lessonStatus) {
        this.lessonStatus = lessonStatus;
    }


    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    // private LessonStatus calculateStatus() {
    // if (isRated()) {
    // return LessonStatus.RATED;
    // }
    //
    // if (isCompleted()) {
    // return LessonStatus.COMPLETED;
    // }
    //
    // if (isNotOpened()) {
    // return LessonStatus.NOT_OPENED;
    // }
    //
    // return LessonStatus.RUNNING;
    // }
    //
    // /**
    // * If ALL tasks are rated then the lesson is considered RATED
    // *
    // * @return RATED lesson status
    // */
    // private boolean isRated() {
    // for (Assignment assignment : assignments) {
    // if (!assignment.getTaskStatus().isRated()) {
    // return false;
    // }
    // }
    //
    // return true;
    // }
    //
    // /**
    // * If ALL tasks are completed OR rated then the lesson is considered COMPLETED
    // *
    // * @return COMPLETED lesson status
    // */
    // private boolean isCompleted() {
    // for (Assignment assignment : assignments) {
    // if (!(assignment.getTaskStatus().isRated() || assignment.getTaskStatus().isCompleted())) {
    // return false;
    // }
    // }
    //
    // return true;
    // }
    //
    // /**
    // * If ALL tasks are not opened then the lesson is considered NOT_OPENED
    // *
    // * @return NOT_OPENED lesson status
    // */
    // private boolean isNotOpened() {
    // for (Assignment assignment : assignments) {
    // if (!assignment.getTaskStatus().isNotOpened()) {
    // return false;
    // }
    // }
    //
    // return true;
    // }

    @Override
    public void doCheckIn(Assessor assessor) {
        lessonStatistics = assessor.assessLesson(this);
    }


    public LessonStatistics getLessonStatistics() {
        if (lessonStatistics == null) {
            doCheckIn(new LessonAssessor());
        }
        return lessonStatistics;
    }

}
