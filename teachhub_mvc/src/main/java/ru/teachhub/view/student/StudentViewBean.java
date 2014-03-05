package ru.teachhub.view.student;

import java.util.ArrayList;
import java.util.Collection;

import ru.teachhub.domain.Contact;
import ru.teachhub.view.lesson.LessonViewBean;

public class StudentViewBean {

    private Contact student;

    private Collection<LessonViewBean> lessonViewBeans = new ArrayList<>();

    public StudentViewBean(Contact student) {
        this.student = student;
    }

    public Contact getStudent() {
        return student;
    }

    public void setStudent(Contact student) {
        this.student = student;
    }

    public Collection<LessonViewBean> getLessonViewBeans() {
        return lessonViewBeans;
    }

    public void setLessonViewBeans(Collection<LessonViewBean> lessonViewBeans) {
        this.lessonViewBeans = lessonViewBeans;
    }

    public void addLessonViewBean(LessonViewBean lessonViewBean) {
        lessonViewBeans.add(lessonViewBean);
    }

    public Long getId() {
        return student.getId();
    }

    public String getTitle() {
        return student.getFirstName() + " " + student.getLastName();
    }

}
