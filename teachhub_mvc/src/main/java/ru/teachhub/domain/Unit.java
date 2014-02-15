package ru.teachhub.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name = "unit")
public class Unit implements Serializable {

    private static final long serialVersionUID = -7202960531984082044L;

    private Long id;

    private String title;

    private String description;

    private Set<UnitTask> unitTasks = new HashSet<UnitTask>();

    public Unit() {
    }

    public Unit(Long id, String title, String description) {
        this(title, description);
        this.id = id;
    }

    public Unit(String title) {
        this.title = title;
    }

    public Unit(String title, String description) {
        this.title = title;
        this.description = description;
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

    @OneToMany(mappedBy = "unit")
    public Set<UnitTask> getUnitTasks() {
        return unitTasks;
    }

    public void setUnitTasks(Set<UnitTask> unitTasks) {
        this.unitTasks = unitTasks;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Unit)) {
            return false;
        }

        if (this == obj) {
            return true;
        }

        Unit otherUnit = (Unit) obj;
        return new EqualsBuilder().append(id, otherUnit.id).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).toHashCode();
    }

}
