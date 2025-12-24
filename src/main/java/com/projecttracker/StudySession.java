package com.projecttracker;

import java.time.LocalDate;
import java.time.LocalTime;

public class StudySession extends Task {
    private LocalTime time;
    private double durationMinutes;
    private UniClass assignedClass;

    public StudySession(String taskName, int taskId, LocalDate date, boolean isDone, String status, LocalTime time, double durationMinutes, UniClass assignedClass){
        super(taskName, taskId, date);
        this.time = time;
        this.durationMinutes = durationMinutes;
        this.assignedClass = assignedClass;
    }
    public double getDurationMinutes(){
        return this.durationMinutes;
    }
    public UniClass getAssignedClass(){
        return this.assignedClass;
    }


    @Override
    public String toString(){
        return "Session: \n"+this.getTaskName()+
        "Class: \n"+this.assignedClass+
        "Duration: \n"+this.getDurationMinutes()+
        "Date: \n"+this.getTaskDate()+
        "Status "+this.getStatus();
    }

}
