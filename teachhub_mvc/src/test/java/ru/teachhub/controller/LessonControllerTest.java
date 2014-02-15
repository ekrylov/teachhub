package ru.teachhub.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import ru.teachhub.domain.task.TaskType;
import ru.teachhub.service.AssignmentService;
import ru.teachhub.service.ContactService;
import ru.teachhub.service.UnitService;
import ru.teachhub.view.lesson.LessonViewBean;
import ru.teachhub.view.task.MultipleChoiceTaskViewBean;
import ru.teachhub.view.task.TaskViewBean;
import static org.mockito.Mockito.*;

public class LessonControllerTest {

    private LessonController lessonController;

    private Model model;

    private Contact contact;

    private Unit unit;

    private List<Assignment> assignments;

    private ContactService contactService;

    private UnitService unitService;

    private AssignmentService assignmentService;

    private TaskProvider taskProvider;

    @Before
    public void setUp() {
        lessonController = new LessonController();
        model = new BindingAwareModelMap();
        contact = new Contact();
        unit = new Unit();
        contact.setAssignments(createSet5Assignments());
        assignments = createList5Assignments();
        taskProvider = new TaskProvider();

        contactService = mock(ContactService.class);
        when(contactService.findById(1L)).thenReturn(contact);

        unitService = mock(UnitService.class);
        when(unitService.findById(1L)).thenReturn(unit);

        assignmentService = mock(AssignmentService.class);
        when(assignmentService.findByContactAndUnitTaskUnit(contact, unit)).thenReturn(assignments);

        ReflectionTestUtils.setField(lessonController, "contactService", contactService);
        ReflectionTestUtils.setField(lessonController, "unitService", unitService);
        ReflectionTestUtils.setField(lessonController, "assignmentService", assignmentService);
        ReflectionTestUtils.setField(lessonController, "taskProvider", taskProvider);
    }

    @Test
    public void lessonsViewIsCorrect() {
        // do
        String url = lessonController.lessons(model);

        // check
        Assert.assertEquals("lesson/student_lesson_list", url);
    }

    @Test
    public void lessonsModelIsNotNull() {
        // do
        lessonController.lessons(model);

        // check
        Assert.assertNotNull(model.asMap().get("lessons"));
    }

    @Test
    public void lessonsModelIsCorrectClass() {
        // do
        lessonController.lessons(model);

        // check
        Assert.assertEquals(ArrayList.class, model.asMap().get("lessons").getClass());
    }

    @Test
    @SuppressWarnings("unchecked")
    public void lessonsModelHasOneBean() {
        // do
        lessonController.lessons(model);

        // check
        List<LessonViewBean> lessonViewBeans = (ArrayList<LessonViewBean>) model.asMap().get("lessons");
        Assert.assertEquals(1, lessonViewBeans.size());
    }

    @Test
    @SuppressWarnings("unchecked")
    public void lessonsModelHasNotNullTaskViewBeans() {
        // do
        lessonController.lessons(model);

        // check
        LessonViewBean lessonViewBean = ((ArrayList<LessonViewBean>) model.asMap().get("lessons")).get(0);
        Assert.assertNotNull(lessonViewBean.getTaskViewBeans());
    }

    @Test
    @SuppressWarnings("unchecked")
    public void lessonsModelHasFiveTaskViewBeans() {
        // do
        lessonController.lessons(model);

        // check
        LessonViewBean lessonViewBean = ((ArrayList<LessonViewBean>) model.asMap().get("lessons")).get(0);
        Assert.assertEquals(5, lessonViewBean.getTaskViewBeans().size());
    }

    @Test
    @SuppressWarnings("unchecked")
    public void lessonsModelChecksTaskViewBeans() {
        // do
        lessonController.lessons(model);
        TaskViewBean taskViewBean1 = createTaskViewBean(1);
        TaskViewBean taskViewBean2 = createTaskViewBean(2);
        TaskViewBean taskViewBean3 = createTaskViewBean(3);
        TaskViewBean taskViewBean4 = createTaskViewBean(4);
        TaskViewBean taskViewBean5 = createTaskViewBean(5);

        // check
        LessonViewBean lessonViewBean = ((ArrayList<LessonViewBean>) model.asMap().get("lessons")).get(0);
        Assert.assertTrue(lessonViewBean.getTaskViewBeans().contains(taskViewBean1));
        Assert.assertTrue(lessonViewBean.getTaskViewBeans().contains(taskViewBean2));
        Assert.assertTrue(lessonViewBean.getTaskViewBeans().contains(taskViewBean3));
        Assert.assertTrue(lessonViewBean.getTaskViewBeans().contains(taskViewBean4));
        Assert.assertTrue(lessonViewBean.getTaskViewBeans().contains(taskViewBean5));
    }

    @Test
    public void showLessonDetailsViewIsCorrect() {
        // setup
        long lessonId = 1;

        // do
        String url = lessonController.showLessonDetails(lessonId, model);

        // check
        Assert.assertEquals("lesson/student_lesson_details", url);
    }

    @Test
    public void showLessonDetailsModelIsNotNull() {
        // setup
        long lessonId = 1;

        // do
        lessonController.showLessonDetails(lessonId, model);

        // check
        Assert.assertNotNull(model.asMap().get("lesson"));
    }

    @Test
    public void showLessonDetailsModelIsCorrectClass() {
        // setup
        long lessonId = 1;

        // do
        lessonController.showLessonDetails(lessonId, model);

        // check
        Assert.assertEquals(LessonViewBean.class, model.asMap().get("lesson").getClass());
    }

    @Test
    public void showLessonDetailsBeanIsInitCorrect() {
        // setup
        long lessonId = 1;

        // do
        lessonController.showLessonDetails(lessonId, model);

        // check
        LessonViewBean lessonViewBean = (LessonViewBean) model.asMap().get("lesson");
        Assert.assertSame(1L, lessonViewBean.getId());
        Assert.assertEquals("title", lessonViewBean.getTitle());
        Assert.assertEquals("description", lessonViewBean.getDescription());
    }

    @Test
    public void showLessonDetailsBeanTaskViewBeansNotNull() {
        // setup
        long lessonId = 1;

        // do
        lessonController.showLessonDetails(lessonId, model);

        // check
        LessonViewBean lessonViewBean = (LessonViewBean) model.asMap().get("lesson");
        Assert.assertNotNull(lessonViewBean.getTaskViewBeans());
    }

    @Test
    public void showLessonDetailsBeanHas5TaskViewBeans() {
        // setup
        long lessonId = 1;

        // do
        lessonController.showLessonDetails(lessonId, model);

        // check
        LessonViewBean lessonViewBean = (LessonViewBean) model.asMap().get("lesson");
        Assert.assertEquals(5, lessonViewBean.getTaskViewBeans().size());
    }

    @Test
    public void showLessonDetailsBeanCheckTaskViewBeans() {
        // setup
        long lessonId = 1;
        TaskViewBean taskViewBean = createTaskViewBean(1);

        // do
        lessonController.showLessonDetails(lessonId, model);

        // check
        LessonViewBean lessonViewBean = (LessonViewBean) model.asMap().get("lesson");
        Assert.assertEquals(taskViewBean, lessonViewBean.getTaskViewBeans().get(0));
        Assert.assertEquals(taskViewBean, lessonViewBean.getTaskViewBeans().get(1));
        Assert.assertEquals(taskViewBean, lessonViewBean.getTaskViewBeans().get(2));
        Assert.assertEquals(taskViewBean, lessonViewBean.getTaskViewBeans().get(3));
        Assert.assertEquals(taskViewBean, lessonViewBean.getTaskViewBeans().get(4));
    }

    @Test
    public void showLessonDetailsEmptyTaskViewBeans() {
        // setup
        long lessonId = 1;
        when(assignmentService.findByContactAndUnitTaskUnit(contact, unit)).thenReturn(
                Collections.<Assignment>emptyList());

        // do
        String url = lessonController.showLessonDetails(lessonId, model);

        // check
        Assert.assertEquals("lesson/student_lesson_error", url);
    }

    @Test
    public void showLessonDetailsEmptyTaskViewBeansModel() {
        // setup
        long lessonId = 1;
        when(assignmentService.findByContactAndUnitTaskUnit(contact, unit)).thenReturn(
                Collections.<Assignment>emptyList());

        // do
        lessonController.showLessonDetails(lessonId, model);

        // check
        Assert.assertTrue(model.asMap().isEmpty());
    }

    private Set<Assignment> createSet5Assignments() {
        return new HashSet<Assignment>(Arrays.asList(createAssignment(1), createAssignment(2), createAssignment(3),
                createAssignment(4), createAssignment(5)));
    }

    private List<Assignment> createList5Assignments() {
        return new ArrayList<Assignment>(Arrays.asList(createAssignment(1), createAssignment(1), createAssignment(1),
                createAssignment(1), createAssignment(1)));
    }

    private TaskViewBean createTaskViewBean(long id) {
        Assignment assignment = new Assignment();
        UnitTask unitTask = new UnitTask();
        Unit unit = new Unit(1L, "title", "description");

        unitTask.setUnit(unit);
        assignment.setUnitTask(unitTask);
        assignment.setId(id);

        return new MultipleChoiceTaskViewBean(assignment);
    }

    private Assignment createAssignment(long id) {
        Assignment assignment = new Assignment();
        UnitTask unitTask = new UnitTask();
        Unit unit = new Unit(1L, "title", "description");
        Task task = new Task();
        TaskContent taskContent = new TaskContent();

        taskContent.setTaskType(TaskType.MULTIPLE_CHOICE);
        task.setTaskContent(taskContent);
        unitTask.setTask(task);
        unitTask.setUnit(unit);
        assignment.setUnitTask(unitTask);
        assignment.setId(id);

        return assignment;
    }

}
