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
import ru.teachhub.domain.TaskContent;
import ru.teachhub.domain.task.TaskProvider;
import ru.teachhub.domain.task.TaskStatus;
import ru.teachhub.service.AssignmentService;
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

        String answer = httpServletRequest.getParameter("option");

        // if (!isValidAnswer(answer)) {
        // uiModel.addAttribute(TASK_BEAN_NAME, taskViewBeanFactory.createTaskViewBean(assignment));
        // return COMMON_TASK_BEAN_TEMPLATE;
        // }

        TaskContent taskContent = assignment.getUnitTask().getTask().getTaskContent();

        // assignment.setMark(Integer.valueOf(answer) == taskContent.getCorrectAnswer() ? taskContent.getPoint() : 0);

        assignment.setAnswer(answer);
        assignment.setTaskStatus(TaskStatus.COMPLETED);
        assignmentService.save(assignment);

        List<Assignment> assignments =
                assignmentService.findByContactAndUnitTaskUnit(assignment.getContact(), assignment.getUnitTask()
                        .getUnit());

        // LessonViewBean lessonViewBean = new LessonViewBean(assignments);
        //
        // uiModel.addAttribute("lessonView", lessonViewBean);

        return "lesson/student_lesson_details";
    }

    // private boolean isValidAnswer(String answer) {
    // return StringUtils.isNotBlank(answer) && StringUtils.isNumeric(answer);
    // }
}
