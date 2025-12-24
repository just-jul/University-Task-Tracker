package com.projecttracker;

import java.time.LocalDate;
import java.time.LocalTime;

public class UniExam extends Task {
    private LocalTime examTime;
    private UniClass assignedClass;
    
    public UniExam(String taskName, int taskId, LocalDate date, boolean isDone, String status, LocalTime examTime, UniClass assigneClass){
        super(taskName, taskId, date);
        this.examTime = examTime;
        this.assignedClass = assigneClass;
    }
    public LocalTime getExamTime(){
        return this.examTime;
    }
    public String getAssignedClass(){
        return this.assignedClass.getClassName();
    }

    @Override
    public String toString(){
        return "Class: \n"+this.assignedClass+
        "Id: \n"+this.getTaskId()+
        "Date: \n"+this.getTaskDate()+
        "Status "+this.getStatus();
    }

}
