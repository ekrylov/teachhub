package ru.teachhub.domain.assessor;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ru.teachhub.domain.Assignment;
import ru.teachhub.domain.Task;
import ru.teachhub.domain.TaskContent;
import ru.teachhub.domain.UnitTask;
import ru.teachhub.domain.lesson.LessonStatistics;
import ru.teachhub.domain.task.TaskStatus;
import ru.teachhub.view.lesson.LessonViewBean;
import ru.teachhub.view.task.MultipleChoiceTaskViewBean;
import ru.teachhub.view.task.TaskViewBean;

public class LessonAssessorTest {

    private Assessor assessor;

    private LessonViewBean emptyLessonViewBean;

    @Before
    public void setUp() {
        assessor = new LessonAssessor();
        emptyLessonViewBean = new LessonViewBean(1L);
    }

    @Test
    public void nullMaxPointsWhenEmptyLessonViewBean() {
        // do
        LessonStatistics lessonStatistics = assessor.assessLesson(emptyLessonViewBean);

        // check
        Assert.assertEquals(0, lessonStatistics.getMaxPoints());
    }

    @Test
    public void nullCurrentPointsWhenEmptyLessonViewBean() {
        // do
        LessonStatistics lessonStatistics = assessor.assessLesson(emptyLessonViewBean);

        // check
        Assert.assertEquals(0, lessonStatistics.getCurrentPoints());
    }

    @Test
    public void nullCommonNumberOfTasksWhenEmptyLessonViewBean() {
        // do
        LessonStatistics lessonStatistics = assessor.assessLesson(emptyLessonViewBean);

        // check
        Assert.assertEquals(0, lessonStatistics.getCommonNumberOfTasks());
    }

    @Test
    public void nullNotOpenedTasksWhenEmptyLessonViewBean() {
        // do
        LessonStatistics lessonStatistics = assessor.assessLesson(emptyLessonViewBean);

        // check
        Assert.assertEquals(0, lessonStatistics.getNotOpenedTasks());
    }

    @Test
    public void nullRunningTasksWhenEmptyLessonViewBean() {
        // do
        LessonStatistics lessonStatistics = assessor.assessLesson(emptyLessonViewBean);

        // check
        Assert.assertEquals(0, lessonStatistics.getRunningTasks());
    }

    @Test
    public void nullCompletedTasksWhenEmptyLessonViewBean() {
        // do
        LessonStatistics lessonStatistics = assessor.assessLesson(emptyLessonViewBean);

        // check
        Assert.assertEquals(0, lessonStatistics.getCompletedTasks());
    }

    @Test
    public void nullRatedTasksWhenEmptyLessonViewBean() {
        // do
        LessonStatistics lessonStatistics = assessor.assessLesson(emptyLessonViewBean);

        // check
        Assert.assertEquals(0, lessonStatistics.getRatedTasks());
    }

    @Test
    public void commonNumberOfTasksIs8() {
        // setup
        LessonViewBean lessonViewBean = new LessonViewBean(1L);
        lessonViewBean.addTaskViewBeans(create8TaskViewBeans());

        // do
        LessonStatistics lessonStatistics = assessor.assessLesson(lessonViewBean);

        // check
        Assert.assertEquals(8, lessonStatistics.getCommonNumberOfTasks());
    }

    @Test
    public void notOpenedTasksIs2() {
        // setup
        LessonViewBean lessonViewBean = new LessonViewBean(1L);
        lessonViewBean.addTaskViewBeans(create8TaskViewBeans());

        // do
        LessonStatistics lessonStatistics = assessor.assessLesson(lessonViewBean);

        // check
        Assert.assertEquals(2, lessonStatistics.getNotOpenedTasks());
    }

    @Test
    public void runningTasksIs2() {
        // setup
        LessonViewBean lessonViewBean = new LessonViewBean(1L);
        lessonViewBean.addTaskViewBeans(create8TaskViewBeans());

        // do
        LessonStatistics lessonStatistics = assessor.assessLesson(lessonViewBean);

        // check
        Assert.assertEquals(2, lessonStatistics.getRunningTasks());
    }

    @Test
    public void completedTasksIs2() {
        // setup
        LessonViewBean lessonViewBean = new LessonViewBean(1L);
        lessonViewBean.addTaskViewBeans(create8TaskViewBeans());

        // do
        LessonStatistics lessonStatistics = assessor.assessLesson(lessonViewBean);

        // check
        Assert.assertEquals(2, lessonStatistics.getCompletedTasks());
    }

    @Test
    public void ratedTasksIs2() {
        // setup
        LessonViewBean lessonViewBean = new LessonViewBean(1L);
        lessonViewBean.addTaskViewBeans(create8TaskViewBeans());

        // do
        LessonStatistics lessonStatistics = assessor.assessLesson(lessonViewBean);

        // check
        Assert.assertEquals(2, lessonStatistics.getRatedTasks());
    }

    @Test
    public void maxPointsIs80() {
        // setup
        LessonViewBean lessonViewBean = new LessonViewBean(1L);
        lessonViewBean.addTaskViewBeans(create8TaskViewBeans());

        // do
        LessonStatistics lessonStatistics = assessor.assessLesson(lessonViewBean);

        // check
        Assert.assertEquals(80, lessonStatistics.getMaxPoints());
    }

    @Test
    public void currentPointsIs14() {
        // setup
        LessonViewBean lessonViewBean = new LessonViewBean(1L);
        lessonViewBean.addTaskViewBeans(create8TaskViewBeans());

        // do
        LessonStatistics lessonStatistics = assessor.assessLesson(lessonViewBean);

        // check
        Assert.assertEquals(14, lessonStatistics.getCurrentPoints());
    }

    private Assignment updateTaskStatus(Assignment assignment, TaskStatus taskStatus) {
        assignment.setTaskStatus(taskStatus);
        return assignment;
    }

    private Assignment createAssignment() {
        Assignment assignment = new Assignment();

        UnitTask unitTask = new UnitTask();

        Task task = new Task();

        TaskContent taskContent = new TaskContent();
        taskContent.setPoint(10);

        task.setTaskContent(taskContent);
        unitTask.setTask(task);

        assignment.setUnitTask(unitTask);
        assignment.setMark(7);
        return assignment;
    }

    private List<TaskViewBean> create8TaskViewBeans() {
        List<TaskViewBean> taskViewBeans = new ArrayList<>();

        taskViewBeans.add(new MultipleChoiceTaskViewBean(updateTaskStatus(createAssignment(), TaskStatus.NOT_OPENED)));
        taskViewBeans.add(new MultipleChoiceTaskViewBean(updateTaskStatus(createAssignment(), TaskStatus.RUNNING)));
        taskViewBeans.add(new MultipleChoiceTaskViewBean(updateTaskStatus(createAssignment(), TaskStatus.COMPLETED)));
        taskViewBeans.add(new MultipleChoiceTaskViewBean(updateTaskStatus(createAssignment(), TaskStatus.RATED)));
        taskViewBeans.add(new MultipleChoiceTaskViewBean(updateTaskStatus(createAssignment(), TaskStatus.NOT_OPENED)));
        taskViewBeans.add(new MultipleChoiceTaskViewBean(updateTaskStatus(createAssignment(), TaskStatus.RUNNING)));
        taskViewBeans.add(new MultipleChoiceTaskViewBean(updateTaskStatus(createAssignment(), TaskStatus.COMPLETED)));
        taskViewBeans.add(new MultipleChoiceTaskViewBean(updateTaskStatus(createAssignment(), TaskStatus.RATED)));

        return taskViewBeans;
    }

}
