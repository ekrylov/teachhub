package ru.teachhub.domain.task;

public enum TaskStatus {

    NOT_OPENED("not opened"), RUNNING("running"), COMPLETED("completed"), RATED("rated"), NOT_DEFINED("not defined");

    private String title;

    TaskStatus(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public boolean isNotOpened() {
        return this == NOT_OPENED;
    }

    public boolean isRunning() {
        return this == RUNNING;
    }

    public boolean isCompleted() {
        return this == COMPLETED;
    }

    public boolean isRated() {
        return this == RATED;
    }

}
