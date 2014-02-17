package ru.teachhub.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ru.teachhub.domain.Assignment;
import ru.teachhub.domain.Contact;
import ru.teachhub.domain.Unit;
import ru.teachhub.domain.task.TaskProvider;
import ru.teachhub.domain.task.TaskStatus;
import ru.teachhub.service.AssignmentService;
import ru.teachhub.service.ContactService;
import ru.teachhub.view.lesson.LessonViewBean;
import ru.teachhub.view.task.TaskViewBean;

@RequestMapping("/task")
@Controller
public class TaskController {

    private static final Logger LOG = LoggerFactory.getLogger(TaskController.class);

    private static final String TASK_BEAN_NAME = "taskView";

    private static final String COMMON_TASK_BEAN_TEMPLATE = "task/student_task";

    @Autowired
    private AssignmentService assignmentService;

    @Autowired
    private TaskProvider taskProvider;

    @Autowired
    private ContactService contactService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String showTask(@PathVariable("id") Long id, Model uiModel) {
        LOG.info("Task details");

        Assignment assignment = assignmentService.findById(id);

        TaskViewBean taskViewBean = taskProvider.createTaskFactory(assignment).createTaskViewBean(assignment);
        taskViewBean.changeStatus(TaskStatus.RUNNING);

        uiModel.addAttribute(TASK_BEAN_NAME, taskViewBean);
        return COMMON_TASK_BEAN_TEMPLATE;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String submit(@PathVariable("id") Long id, Model uiModel, HttpServletRequest httpServletRequest) {
        LOG.info("Submit task");

        Assignment assignment = assignmentService.findById(id);
        Contact contact = contactService.findById(1L);

        assignment.setAnswer(httpServletRequest.getParameter("option"));
        assignment.setTaskStatus(TaskStatus.COMPLETED);
        assignmentService.save(assignment);

        List<Assignment> assignments =
                assignmentService.findByContactAndUnitTaskUnit(contact, assignment.getUnitTask().getUnit());

        uiModel.addAttribute("lesson", createLessonViewBean(assignments));

        return "lesson/student_lesson_details";
    }

    private LessonViewBean createLessonViewBean(List<Assignment> assignments) {
        Unit unit = assignments.get(0).getUnitTask().getUnit();

        LessonViewBean lessonViewBean = new LessonViewBean(unit.getId(), unit.getTitle(), unit.getDescription());
        for (Assignment assignment : assignments) {
            lessonViewBean.addTaskViewBean(taskProvider.createTaskFactory(assignment).createTaskViewBean(assignment));
        }

        return lessonViewBean;
    }
}
