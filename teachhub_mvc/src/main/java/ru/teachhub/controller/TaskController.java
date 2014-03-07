package ru.teachhub.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ru.teachhub.authentication.SpringSecurityUserContext;
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

    private static final String ERROR_TASK_BEAN_TEMPLATE = "task/student_task_error";

    @Autowired
    private AssignmentService assignmentService;

    @Autowired
    private TaskProvider taskProvider;

    @Autowired
    private ContactService contactService;

    @Autowired
    private SpringSecurityUserContext springSecurityUserContext;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasRole('student')")
    public String showTask(@PathVariable("id") Long id, Model uiModel) {
        LOG.info("Task details");

        Contact student = springSecurityUserContext.getContact();
        Assignment assignment = assignmentService.findById(id);

        if (!assignment.getStudent().equals(student)) {
            return ERROR_TASK_BEAN_TEMPLATE;
        }

        TaskViewBean taskViewBean = taskProvider.createTaskFactory(assignment).createTaskViewBean(assignment);
        taskViewBean.changeStatus(TaskStatus.RUNNING);

        uiModel.addAttribute(TASK_BEAN_NAME, taskViewBean);
        return COMMON_TASK_BEAN_TEMPLATE;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    @PreAuthorize("hasRole('student')")
    public String submit(@PathVariable("id") Long id, Model uiModel, HttpServletRequest httpServletRequest) {
        LOG.info("Submit task");

        Contact student = springSecurityUserContext.getContact();
        Assignment assignment = assignmentService.findById(id);

        if (!assignment.getStudent().equals(student)) {
            return ERROR_TASK_BEAN_TEMPLATE;
        }

        assignment.setAnswer(httpServletRequest.getParameter("option"));
        assignment.setTaskStatus(TaskStatus.COMPLETED);
        assignmentService.save(assignment);

        List<Assignment> assignments =
                assignmentService.findByContactAndUnitTaskUnit(student, assignment.getUnitTask().getUnit());

        uiModel.addAttribute("lesson", createLessonViewBean(assignments));

        return "redirect:/lesson/" + assignment.getUnitTask().getUnit().getId();
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
