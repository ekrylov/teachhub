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

@Entity
@Table( name = "assignment" )
public class Assignment
    implements Serializable
{

    private static final long serialVersionUID = -4527240554939450246L;

    private Long id;

    private Contact contact;

    private UnitTask unitTask;

    private TaskStatus taskStatus;

    private int mark;

    public Assignment()
    {

    }

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "ID" )
    public Long getId()
    {
        return id;
    }

    public void setId( Long id )
    {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn( name = "CONTACT_ID", updatable = false, insertable = false )
    public Contact getContact()
    {
        return contact;
    }

    public void setContact( Contact contact )
    {
        this.contact = contact;
    }

    @ManyToOne
    @JoinColumn( name = "UNIT_TASK_ID", updatable = false, insertable = false )
    public UnitTask getUnitTask()
    {
        return unitTask;
    }

    public void setUnitTask( UnitTask unitTask )
    {
        this.unitTask = unitTask;
    }

    @Column( name = "STATUS" )
    @Enumerated( EnumType.STRING )
    public TaskStatus getTaskStatus()
    {
        return taskStatus;
    }

    public void setTaskStatus( TaskStatus taskStatus )
    {
        this.taskStatus = taskStatus;
    }

    @Column( name = "MARK" )
    public int getMark()
    {
        return mark;
    }

    public void setMark( int mark )
    {
        this.mark = mark;
    }

}
