package ru.teachhub.controller;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;

import ru.teachhub.domain.Assignment;
import ru.teachhub.domain.Contact;
import ru.teachhub.domain.Task;
import ru.teachhub.domain.TaskContent;
import ru.teachhub.domain.Unit;
import ru.teachhub.domain.UnitTask;
import ru.teachhub.domain.task.TaskProvider;
import ru.teachhub.domain.task.TaskStatus;
import ru.teachhub.domain.task.TaskType;
import ru.teachhub.service.AssignmentService;
import ru.teachhub.service.ContactService;
import ru.teachhub.view.task.MultipleChoiceTaskViewBean;

public class TaskControllerTest {

    private Model model;

    private Contact contact;

    private AssignmentService assignmentService;

    private ContactService contactService;

    private TaskProvider taskProvider;

    private Assignment assignment;

    private TaskController taskController;

    @Before
    public void setUp() {
        taskController = new TaskController();
        model = new BindingAwareModelMap();
        contact = new Contact();
        assignment = createAssignment(1L, 1L);
        taskProvider = new TaskProvider();

        assignmentService = mock(AssignmentService.class);
        when(assignmentService.findById(1L)).thenReturn(assignment);

        contactService = mock(ContactService.class);
        when(contactService.findById(1L)).thenReturn(contact);

        ReflectionTestUtils.setField(taskController, "assignmentService", assignmentService);
        ReflectionTestUtils.setField(taskController, "contactService", contactService);
        ReflectionTestUtils.setField(taskController, "taskProvider", taskProvider);
    }

    @Test
    public void showViewIsCorrect() {
        // do
        String url = taskController.showTask(1L, model);

        // check
        Assert.assertEquals("task/student_task", url);
    }

    @Test
    public void showModelIsNotNull() {
        // do
        taskController.showTask(1L, model);

        // check
        Assert.assertNotNull(model.asMap().get("taskView"));
    }

    @Test
    public void showModelIsCorrectClass() {
        // do
        taskController.showTask(1L, model);

        // check
        Assert.assertEquals(MultipleChoiceTaskViewBean.class, model.asMap().get("taskView").getClass());
    }

    @Test
    public void showTaskViewBeanTemplateCorrect() {
        // do
        taskController.showTask(1L, model);

        // check
        MultipleChoiceTaskViewBean taskViewBean = (MultipleChoiceTaskViewBean) model.asMap().get("taskView");
        Assert.assertEquals("multiple_choice_task.jspx", taskViewBean.getTemplate());
    }

    @Test
    public void showTaskViewBeanAssignmentCorrect() {
        // do
        taskController.showTask(1L, model);

        // check
        MultipleChoiceTaskViewBean taskViewBean = (MultipleChoiceTaskViewBean) model.asMap().get("taskView");
        Assert.assertEquals(assignment, taskViewBean.getAssignment());
    }

    @Test
    public void showTaskViewBeanTaskCorrect() {
        // setup
        Task expectedTask = createTask(1L);

        // do
        taskController.showTask(1L, model);

        // check
        MultipleChoiceTaskViewBean taskViewBean = (MultipleChoiceTaskViewBean) model.asMap().get("taskView");
        Assert.assertEquals(expectedTask, taskViewBean.getTask());
    }

    @Test
    public void showTaskViewBeanOpenable() {
        // do
        taskController.showTask(1L, model);

        // check
        MultipleChoiceTaskViewBean taskViewBean = (MultipleChoiceTaskViewBean) model.asMap().get("taskView");
        Assert.assertTrue(taskViewBean.isOpenable());
    }

    @Test
    public void showTaskStatusRunning() {
        // do
        taskController.showTask(1L, model);

        // check
        MultipleChoiceTaskViewBean taskViewBean = (MultipleChoiceTaskViewBean) model.asMap().get("taskView");
        Assert.assertEquals(TaskStatus.RUNNING, taskViewBean.getAssignment().getTaskStatus());
    }

    private Assignment createAssignment(long assignmentId, long taskId) {
        Assignment assignment = new Assignment();
        UnitTask unitTask = new UnitTask();
        Unit unit = new Unit(1L, "title", "description");
        Task task = createTask(taskId);
        TaskContent taskContent = new TaskContent();

        taskContent.setTaskType(TaskType.MULTIPLE_CHOICE);
        task.setTaskContent(taskContent);
        unitTask.setTask(task);
        unitTask.setUnit(unit);
        assignment.setUnitTask(unitTask);
        assignment.setId(assignmentId);

        return assignment;
    }

    private Task createTask(long id) {
        return new Task(id);
    }

}
