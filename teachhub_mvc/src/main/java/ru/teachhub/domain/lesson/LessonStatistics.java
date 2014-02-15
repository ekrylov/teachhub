package ru.teachhub.domain.lesson;

import ru.teachhub.domain.task.TaskStatus;

public class LessonStatistics {

    private int commonNumberOfTasks;

    private int notOpenedTasks;

    private int runningTasks;

    private int completedTasks;

    private int ratedTasks;

    private int maxPoints;

    private int currentPoints;

    public void updateStatistics(TaskStatus taskStatus) {
        switch (taskStatus) {
            case NOT_OPENED:
                commonNumberOfTasks++;
                notOpenedTasks++;
                break;
            case RUNNING:
                commonNumberOfTasks++;
                runningTasks++;
                break;
            case COMPLETED:
                commonNumberOfTasks++;
                completedTasks++;
                break;
            case RATED:
                commonNumberOfTasks++;
                ratedTasks++;
                break;
            default:
                break;
        }
    }

    public int getCommonNumberOfTasks() {
        return commonNumberOfTasks;
    }

    public int getNotOpenedTasks() {
        return notOpenedTasks;
    }

    public int getRunningTasks() {
        return runningTasks;
    }

    public int getCompletedTasks() {
        return completedTasks;
    }

    public int getRatedTasks() {
        return ratedTasks;
    }

    public int getMaxPoints() {
        return maxPoints;
    }

    public void setMaxPoints(int maxPoints) {
        this.maxPoints = maxPoints;
    }

    public int getCurrentPoints() {
        return currentPoints;
    }

    public void setCurrentPoints(int currentPoints) {
        this.currentPoints = currentPoints;
    }


}
