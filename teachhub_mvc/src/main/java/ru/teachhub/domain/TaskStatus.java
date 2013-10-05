package ru.teachhub.domain;

public enum TaskStatus
{

    NOT_OPENED( "not opened" ), RUNNING( "running" ), COMPLETED( "completed" ), RATED( "rated" );

    private String title;

    TaskStatus( String title )
    {
        this.title = title;
    }

    public String getTitle()
    {
        return title;
    }

}
