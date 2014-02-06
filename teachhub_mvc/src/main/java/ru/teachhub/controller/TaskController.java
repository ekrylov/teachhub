package ru.teachhub.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
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
import ru.teachhub.domain.TaskStatus;
import ru.teachhub.service.AssignmentService;
import ru.teachhub.view.lesson.LessonViewBean;
import ru.teachhub.view.task.TaskViewBean;
import ru.teachhub.view.task.TaskViewBeanFactory;

@RequestMapping("/task")
@Controller
public class TaskController {

    private static final Logger logger = LoggerFactory.getLogger(TaskController.class);

    @Autowired
    private AssignmentService assignmentService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String showTask(@PathVariable("id") Long id, Model uiModel) {
        logger.info("Task details");

        Assignment assignment = assignmentService.findById(id);
        
        TaskViewBean taskViewBean = TaskViewBeanFactory.createTaskViewBean(assignment);
        taskViewBean.changeStatus(TaskStatus.RUNNING);
        uiModel.addAttribute("taskView", taskViewBean);

        return "task/student_task";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String submit(@PathVariable("id") Long id, Model uiModel, HttpServletRequest httpServletRequest) {
        logger.info("Submit task");

        Assignment assignment = assignmentService.findById(id);

        String answer = httpServletRequest.getParameter("option");
        
        if (!isValidAnswer(answer)) {
            uiModel.addAttribute("taskView", TaskViewBeanFactory.createTaskViewBean(assignment));
            return "task/student_task";
        }

        TaskContent taskContent = assignment.getUnitTask().getTask().getTaskContent();

        assignment.setMark(Integer.valueOf(answer) == taskContent.getCorrectAnswer() ? taskContent.getPoint() : 0);
        assignment.setTaskStatus(TaskStatus.COMPLETED);
        assignmentService.save(assignment);

        List<Assignment> assignments =
                assignmentService.findByContactAndUnitTaskUnit(assignment.getContact(), assignment.getUnitTask()
                        .getUnit());
        
        LessonViewBean lessonViewBean = new LessonViewBean(assignments);
        
        uiModel.addAttribute("lessonView", lessonViewBean);

        return "lesson/student_lesson_details";
    }

    private boolean isValidAnswer(String answer) {
        return StringUtils.isNotBlank(answer) && StringUtils.isNumeric(answer);
    }

//    private void fillModel(Long id, Model uiModel, Assignment assignment) {
//        List<String> answerOptions =
//                new ArrayList<String>(Arrays.asList(assignment.getUnitTask().getTask().getTaskContent()
//                        .getResponseOption().split(OPTIONS_SEPARATOR)));
//
//        uiModel.addAttribute("unitTask", assignment.getUnitTask());
//        uiModel.addAttribute("options", answerOptions);
//    }
}
