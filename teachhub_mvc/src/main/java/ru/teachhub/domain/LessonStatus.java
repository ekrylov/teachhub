package ru.teachhub.domain;

public enum LessonStatus {

    NOT_OPENED("not opened"), RUNNING("running"), COMPLETED("completed"), RATED("rated");

    private String title;

    LessonStatus(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
    
    @Override
    public String toString() {
        return title;
    }

}
