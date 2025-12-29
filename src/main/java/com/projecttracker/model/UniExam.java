package com.projecttracker.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class UniExam extends Task {
    private LocalTime examTime;
    private UniClass assignedClass;
    
    public UniExam(String taskName, LocalDate date, LocalTime examTime, UniClass assigneClass){
        super(taskName, date);
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
        return "Exam: \n"+this.getTaskName()+
        "Class: \n"+this.assignedClass+
        "Date: \n"+this.getTaskDate()+
        "Time: \n"+this.getExamTime();
    }

}
