package com.projecttracker.model;

import java.time.LocalDate;

public class UniTask extends Task {
    private UniClass assignedClass;

    public UniTask(String taskName, LocalDate date, UniClass assignedClass){
        super(taskName, date);
        this.assignedClass = assignedClass;
    }


    @Override
    public String toString(){
        return "Task name: "+this.getTaskName()+"\n"+
        "Due: "+this.getTaskDate()+"\n"+
        "Status "+this.getStatus()+"\n";
    }
}
