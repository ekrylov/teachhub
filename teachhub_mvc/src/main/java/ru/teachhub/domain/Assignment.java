package ru.teachhub.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import ru.teachhub.domain.task.TaskStatus;

@Entity
@Table(name = "assignment")
public class Assignment implements Serializable {

    private static final long serialVersionUID = -4527240554939450246L;

    private Long id;

    private Contact student;
    
    private Contact teacher;

    private UnitTask unitTask;

    private TaskStatus taskStatus = TaskStatus.NOT_OPENED;

    private int mark;

    private String answer;

    public Assignment() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "STUDENT_ID", updatable = false, insertable = false)
    public Contact getStudent() {
        return student;
    }

    public void setStudent(Contact student) {
        this.student = student;
    }
    
    @ManyToOne
    @JoinColumn(name = "TEACHER_ID", updatable = false, insertable = false)
    public Contact getTeacher() {
        return teacher;
    }

    public void setTeacher(Contact teacher) {
        this.teacher = teacher;
    }

    @ManyToOne
    @JoinColumn(name = "UNIT_TASK_ID", updatable = false, insertable = false)
    public UnitTask getUnitTask() {
        return unitTask;
    }

    public void setUnitTask(UnitTask unitTask) {
        this.unitTask = unitTask;
    }

    @Column(name = "STATUS")
    @Enumerated(EnumType.ORDINAL)
    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    @Column(name = "MARK")
    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    @Column(name = "ANSWER")
    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Assignment)) {
            return false;
        }

        if (this == obj) {
            return true;
        }

        Assignment otherAssignment = (Assignment) obj;
        return new EqualsBuilder().append(id, otherAssignment.id).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).toHashCode();
    }
    
}
