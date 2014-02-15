package ru.teachhub.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
import ru.teachhub.service.AssignmentService;
import ru.teachhub.service.ContactService;
import ru.teachhub.service.UnitService;
import ru.teachhub.view.lesson.LessonViewBean;

@RequestMapping("/lesson")
@Controller
public class LessonController {

    private static final Logger LOG = LoggerFactory.getLogger(LessonController.class);

    @Autowired
    private UnitService unitService;

    @Autowired
    private ContactService contactService;

    @Autowired
    private AssignmentService assignmentService;

    @Autowired
    private TaskProvider taskProvider;

    @RequestMapping(method = RequestMethod.GET)
    public String lessons(Model uiModel) {
        LOG.info("Listing lessons");

        Contact contact = contactService.findById(1L);
        uiModel.addAttribute("lessons", createLessonViewBeans(groupLessons(contact.getAssignments())));

        return "lesson/student_lesson_list";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String showLessonDetails(@PathVariable("id") Long id, Model uiModel) {
        LOG.info("Lesson details");

        Unit unit = unitService.findById(id);
        Contact contact = contactService.findById(1L);

        List<Assignment> assignments = assignmentService.findByContactAndUnitTaskUnit(contact, unit);

        if (assignments.isEmpty()) {
            return "lesson/student_lesson_error";
        }

        uiModel.addAttribute("lesson", createLessonViewBean(assignments));
        return "lesson/student_lesson_details";
    }

    private Map<Unit, LessonViewBean> groupLessons(Collection<Assignment> assignments) {
        Map<Unit, LessonViewBean> lessons = new HashMap<>();
        for (Assignment assignment : assignments) {
            Unit key = assignment.getUnitTask().getUnit();
            if (!lessons.containsKey(key)) {
                lessons.put(key, new LessonViewBean(key.getId(), key.getTitle(), key.getDescription()));
            }

            lessons.get(assignment.getUnitTask().getUnit()).addTaskViewBean(
                    taskProvider.createTaskFactory(assignment).createTaskViewBean(assignment));
        }

        return lessons;
    }

    private List<LessonViewBean> createLessonViewBeans(Map<Unit, LessonViewBean> lessonsMap) {
        List<LessonViewBean> lessons = new ArrayList<>();

        for (Entry<Unit, LessonViewBean> entry : lessonsMap.entrySet()) {
            lessons.add(entry.getValue());
        }

        return lessons;
    }

    /**
     * Creates LessonViewBean object and initiates it by assignments
     * @param assignments the list of Assignment should be non-empty
     * @return LessonViewBean
     */
    private LessonViewBean createLessonViewBean(List<Assignment> assignments) {
        Unit unit = assignments.get(0).getUnitTask().getUnit();

        LessonViewBean lessonViewBean = new LessonViewBean(unit.getId(), unit.getTitle(), unit.getDescription());
        for (Assignment assignment : assignments) {
            lessonViewBean.addTaskViewBean(taskProvider.createTaskFactory(assignment).createTaskViewBean(assignment));
        }

        return lessonViewBean;
    }
}
