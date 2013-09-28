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
import javax.persistence.Table;

@Entity
@Table(name = "unit")
public class Unit implements Serializable {

	private static final long serialVersionUID = -7202960531984082044L;

	private Long id;
	private String title;
	private String description;
	private Set<Task> tasks = new HashSet<Task>();

	public Unit() {
	}
	
	public Unit(Long id, String title, String description, Set<Task> tasks) {
		this(title, description, tasks);
		this.id = id;
	}

	public Unit(String title) {
		this.title = title;
	}

	public Unit(String title, String description, Set<Task> tasks) {
		this.title = title;
		this.description = description;
		this.tasks = tasks;
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

	// TODO: make loading is lazy but figure out how to avoid closing session
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "UNIT_TASK", joinColumns = @JoinColumn(name = "UNIT_ID"), inverseJoinColumns = @JoinColumn(name = "TASK_ID"))
	public Set<Task> getTasks() {
		return tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}

}
