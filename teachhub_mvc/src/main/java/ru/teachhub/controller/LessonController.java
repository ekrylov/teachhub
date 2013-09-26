package ru.teachhub.controller;

import java.util.ArrayList;
import java.util.HashSet;
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

		List<Unit> lessons = getFakeLessons();
		uiModel.addAttribute("lessons", lessons);

		logger.info("No. of lessons: " + lessons.size());

		return "lesson/student_lesson_list";
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String showLessonDetails(@PathVariable("id") Long id, Model uiModel) {
		logger.info("Lesson details");

		Unit lesson = getFakeLesson(id);
		uiModel.addAttribute("lesson", lesson);

		return "lesson/student_lesson_details";
	}
	
	private List<Unit> getFakeLessons() {
		List<Unit> lessons = new ArrayList<Unit>();
		for (int i = 0; i < 10; i++) {
			Set<Task> tasks = new HashSet<Task>();
			for (int j = 0; j < (i + 1); j++) {
				tasks.add(new Task("Task #" + (j + 1)));
			}
			lessons.add(new Unit(i + 1L, "Lesson #" + (i + 1), "Описание урока", tasks));
		}
		return lessons;
	}
	
	private Unit getFakeLesson(Long id) {
		Set<Task> tasks = new HashSet<Task>();
		for (int j = 0; j < id; j++) {
			tasks.add(new Task("Task #" + (j + 1)));
		}
		return new Unit(id, "Lesson #" + id, "Описание урока", tasks);
	}

}
