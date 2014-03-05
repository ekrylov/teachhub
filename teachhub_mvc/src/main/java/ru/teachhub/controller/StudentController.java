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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ru.teachhub.authentication.SpringSecurityUserContext;
import ru.teachhub.domain.Assignment;
import ru.teachhub.domain.Contact;
import ru.teachhub.view.student.StudentViewBean;

@RequestMapping("/student")
@Controller
public class StudentController {

    private static final Logger LOG = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private SpringSecurityUserContext springSecurityUserContext;

    @RequestMapping(method = RequestMethod.GET)
    @PreAuthorize("hasRole('teacher')")
    public String students(Model uiModel) {
        LOG.info("Listing students");

        Contact contact = springSecurityUserContext.getContact();
        uiModel.addAttribute("students", createStudentViewBean(groupStudents(contact.getTeacherAssignments())));

        return "student/student_list";
    }

    private Map<Contact, StudentViewBean> groupStudents(Collection<Assignment> assignments) {
        Map<Contact, StudentViewBean> students = new HashMap<Contact, StudentViewBean>();

        for (Assignment assignment : assignments) {
            Contact studentKey = assignment.getStudent();
            if (!students.containsKey(studentKey)) {
                students.put(studentKey, new StudentViewBean(studentKey));
            }
        }

        return students;
    }

    private List<StudentViewBean> createStudentViewBean(Map<Contact, StudentViewBean> studentsMap) {
        List<StudentViewBean> students = new ArrayList<>(studentsMap.size());

        for (Entry<Contact, StudentViewBean> student : studentsMap.entrySet()) {
            students.add(student.getValue());
        }

        return students;
    }

}
