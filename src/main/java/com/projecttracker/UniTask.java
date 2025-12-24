package com.projecttracker;

import java.time.LocalDate;

public class UniTask extends Task {
    private UniClass assignedClass;

    public UniTask(String taskName, int taskId, LocalDate date, UniClass assignedClass){
        super(taskName, taskId, date);
        this.assignedClass = assignedClass;
    }


    @Override
    public String toString(){
        return "Task name: \n"+this.getTaskName()+
        "Id: \n"+this.getTaskId()+
        "Due: \n"+this.getTaskDate()+
        "Status "+this.getStatus();
    }
}
