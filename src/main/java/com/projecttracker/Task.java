package com.projecttracker;

import java.time.LocalDate;

public abstract class Task implements Trackable{
    private String taskName;
    private int taskId;
    private LocalDate date;
    private boolean isDone;
    private String status;

    public Task(String taskName, int taskId, LocalDate date){
        this.taskName = taskName;
        this.taskId = taskId;
        this.date = date;
        this.isDone = false;
        this.status = "TO_DO";
    }
    public String getTaskName(){
        return this.taskName;
    }
    public void setTaskName(String name){
        this.taskName = name;
    }
    public int getTaskId(){
        return this.taskId;
    }
    public LocalDate getTaskDate(){
        return this.date;
    }

    @Override
    public void markDone(){
        this.isDone = true;
        this.status = "DONE";
    }
    @Override
    public String getStatus(){
        return this.status;
    }
    @Override
    public void start(){
        this.isDone = false;
        this.status = "IN_PROGRESS";
    }


}
