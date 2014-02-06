package ru.teachhub.view.lesson;

import java.util.List;

import ru.teachhub.domain.Assignment;
import ru.teachhub.domain.LessonStatus;

/**
 * Presentation of a single lesson
 * 
 * @author ekrylov
 * 
 */
public class LessonViewBean {

    /**
     * Assignments corresponding the lesson
     */
    private List<Assignment> assignments;

    /**
     * The status of the lesson (base on the status its tasks)
     */
    private LessonStatus lessonStatus;

    /**
     * The title of the lesson
     */
    private String title;

    /**
     * The description of the lesson
     */
    private String description;

    public LessonViewBean(List<Assignment> assignments) {
        this.assignments = assignments;

        if (!assignments.isEmpty()) {
            this.title = assignments.get(0).getUnitTask().getUnit().getTitle();
            this.description = assignments.get(0).getUnitTask().getUnit().getDescription();
        }
        
        setLessonStatus(calculateStatus());
    }


    public List<Assignment> getAssignments() {
        return assignments;
    }


    public void setAssignments(List<Assignment> assignments) {
        this.assignments = assignments;
    }


    public LessonStatus getLessonStatus() {
        return lessonStatus;
    }

    public void setLessonStatus(LessonStatus lessonStatus) {
        this.lessonStatus = lessonStatus;
    }


    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }

    private LessonStatus calculateStatus() {
        if (isRated()) {
            return LessonStatus.RATED;
        }
        
        if (isCompleted()) {
            return LessonStatus.COMPLETED;
        }
        
        if (isNotOpened()) {
            return LessonStatus.NOT_OPENED;
        }
        
        return LessonStatus.RUNNING;
    }

    /**
     * If ALL tasks are rated then the lesson is considered RATED
     * 
     * @return RATED lesson status
     */
    private boolean isRated() {
        for (Assignment assignment : assignments) {
            if (!assignment.getTaskStatus().isRated()) {
                return false;
            }
        }
        
        return true;
    }
    
    /**
     * If ALL tasks are completed OR rated then the lesson is considered COMPLETED
     * 
     * @return COMPLETED lesson status
     */
    private boolean isCompleted() {
        for (Assignment assignment : assignments) {
            if (!(assignment.getTaskStatus().isRated() || assignment.getTaskStatus().isCompleted())) {
                return false;
            }
        }
        
        return true;
    }
    
    /**
     * If ALL tasks are not opened then the lesson is considered NOT_OPENED
     * 
     * @return NOT_OPENED lesson status
     */
    private boolean isNotOpened() {
        for (Assignment assignment : assignments) {
            if (!assignment.getTaskStatus().isNotOpened()) {
                return false;
            }
        }
        
        return true;
    }
    
}
