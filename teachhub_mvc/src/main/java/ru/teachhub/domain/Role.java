package ru.teachhub.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;

@Entity
@Table(name = "role")
public class Role implements Serializable {

	private static final long serialVersionUID = -150501727785592132L;

	private Long id;
	private String title;
	private String privilege;
	private Set<Contact> contacts = new HashSet<Contact>();

	public Role() {
	}

	public Role(String title, String privilege) {
		this.title = title;
		this.privilege = privilege;
	}

	public Role(Long id) {
		super();
		this.id = id;
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

	@Column(name = "PRIVILEGE")
	public String getPrivilege() {
		return privilege;
	}

	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}

	@OneToMany(mappedBy = "role", cascade = CascadeType.ALL, orphanRemoval = true)
	public Set<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
	}

	@Override
	public String toString() {
		return "Role Id: " + id + ", title: " + title + ", privilege: "
				+ privilege;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Role)) {
			return false;
		}

		if (this == obj) {
			return true;
		}

		Role otherRole = (Role) obj;
		return new EqualsBuilder().append(title, otherRole.title)
				.append(privilege, otherRole.privilege).isEquals();
	}

}
