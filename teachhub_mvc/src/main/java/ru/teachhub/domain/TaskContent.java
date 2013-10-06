package ru.teachhub.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "task_content" )
public class TaskContent
    implements Serializable
{

    private static final long serialVersionUID = 8908641287762727874L;

    private Long id;

    private TaskType taskType;

    private String question;

    private String responseOption;

    private int correctAnswer;

    private int point;

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

    @Column( name = "TASK_TYPE" )
    @Enumerated( EnumType.STRING )
    public TaskType getTaskType()
    {
        return taskType;
    }

    public void setTaskType( TaskType taskType )
    {
        this.taskType = taskType;
    }

    @Column( name = "QUESTION" )
    public String getQuestion()
    {
        return question;
    }

    public void setQuestion( String question )
    {
        this.question = question;
    }

    @Column( name = "RESPONSE_OPTION" )
    public String getResponseOption()
    {
        return responseOption;
    }

    public void setResponseOption( String responseOption )
    {
        this.responseOption = responseOption;
    }

    @Column( name = "CORRECT_ANSWER" )
    public int getCorrectAnswer()
    {
        return correctAnswer;
    }

    public void setCorrectAnswer( int correctAnswer )
    {
        this.correctAnswer = correctAnswer;
    }

    @Column( name = "POINT" )
    public int getPoint()
    {
        return point;
    }

    public void setPoint( int point )
    {
        this.point = point;
    }

}
