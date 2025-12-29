package com.projecttracker;

import java.time.LocalDate;

public class UniTask extends Task {
    private UniClass assignedClass;

    public UniTask(String taskName, LocalDate date, UniClass assignedClass){
        super(taskName, date);
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
