package ru.teachhub.view.task;

import org.junit.Assert;
import org.junit.Test;

import ru.teachhub.domain.Assignment;
import ru.teachhub.domain.Task;
import ru.teachhub.domain.UnitTask;
import ru.teachhub.domain.task.TaskStatus;

public class AbstractTaskViewBeanTest {

    @Test
    public void testCheckTask() {
        Assignment assignment = new Assignment();
        UnitTask unitTask = new UnitTask();
        Task task = new Task();
        unitTask.setTask(task);
        assignment.setUnitTask(unitTask);

        AbstractTaskViewBean abstractTaskViewBean = new AbstractTaskViewBean(assignment) {
            @Override
            public String getTemplate() {
                // TODO Auto-generated method stub
                return null;
            }
        };

        Assert.assertEquals(task, abstractTaskViewBean.getTask());
    }

    @Test
    public void testChangeStatus() {
        Assignment assignment = new Assignment();
        assignment.setTaskStatus(TaskStatus.NOT_OPENED);

        AbstractTaskViewBean abstractTaskViewBean = new AbstractTaskViewBean(assignment) {
            @Override
            public String getTemplate() {
                // TODO Auto-generated method stub
                return null;
            }
        };

        abstractTaskViewBean.changeStatus(TaskStatus.RUNNING);

        Assert.assertEquals(TaskStatus.RUNNING, abstractTaskViewBean.getAssignment().getTaskStatus());
    }

}
