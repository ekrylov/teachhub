package ru.teachhub.controller;

import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ru.teachhub.domain.Task;
import ru.teachhub.domain.Unit;
import ru.teachhub.service.UnitService;

@RequestMapping("/lesson")
@Controller
public class LessonController {

	private static final Logger logger = LoggerFactory
			.getLogger(LessonController.class);

	@Autowired
	private UnitService unitService;

	@RequestMapping(method = RequestMethod.GET)
	public String lessons(Model uiModel) {
		logger.info("Listing lessons");

		List<Unit> lessons = unitService.findAll();
		uiModel.addAttribute("lessons", lessons);
		uiModel.addAttribute("recommendedLesson", lessons.get(0));

		logger.info("No. of lessons: " + lessons.size());

		return "lesson/student_lesson_list";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String showLessonDetails(@PathVariable("id") Long id, Model uiModel) {
		logger.info("Lesson details");

		Unit lesson = unitService.findById(id);
		Set<Task> tasks = lesson.getTasks();
		for (Task task : tasks) {
			System.out.println(task.getTitle());
		}
		uiModel.addAttribute("lesson", lesson);

		return "lesson/student_lesson_details";
	}
}
