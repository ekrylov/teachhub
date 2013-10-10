package ru.teachhub.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "task")
public class Task implements Serializable {

    private static final long serialVersionUID = 1543497734083747424L;

    private Long id;

    private TaskContent taskContent;

    private String title;

    private String description;

    private Set<UnitTask> unitTasks = new HashSet<UnitTask>();

    private Set<Tag> tags = new HashSet<Tag>();

    public Task() {
    }

    public Task(String title) {
        this.title = title;
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

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID")
    public TaskContent getTaskContent() {
        return taskContent;
    }

    public void setTaskContent(TaskContent taskContent) {
        this.taskContent = taskContent;
    }

    @Column(name = "TITLE")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @OneToMany(mappedBy = "task")
    public Set<UnitTask> getUnitTasks() {
        return unitTasks;
    }

    public void setUnitTasks(Set<UnitTask> unitTasks) {
        this.unitTasks = unitTasks;
    }

    @ManyToMany
    @JoinTable(name = "TASK_TAG", joinColumns = @JoinColumn(name = "TASK_ID"), inverseJoinColumns = @JoinColumn(
            name = "TAG_ID"))
    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

}
