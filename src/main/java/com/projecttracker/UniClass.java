package com.projecttracker;

import java.util.ArrayList;

public class UniClass {
    private String name;
    private String id;
    private String teacher;
    private Repository<UniTask> uniTasks;
    private Repository<UniExam> uniExams;
    private Repository<StudySession> studySessions;

    public UniClass(String name, String id, String teacher){
        this.name = name;
        this.id = id;
        this.teacher = teacher;
        this.uniTasks = new Repository<>();
        this.uniExams = new Repository<>();
        this.studySessions = new Repository<>();
    }
    public String getClassName(){
        return this.name;
    }
    public String getClassId(){
        return this.id;
    }
    public String getTeacher(){
        return this.teacher;
    }

    public ArrayList<UniTask> getUniTasks(){
        ArrayList<UniTask> uniTaskList = this.uniTasks.getList();
        return uniTaskList;
    }
    public ArrayList<UniExam> getExamList(){
        ArrayList<UniExam> examList = this.uniExams.getList();
        return examList;
    }
    public ArrayList<StudySession> getStudySessions(){
        ArrayList<StudySession> studySessionList = this.studySessions.getList();
        return studySessionList;
    }
    public void printTasks(){
        System.out.println("---- TASKS ----");
        for(UniTask task : uniTasks.getList()){
            System.out.println(task);
        }
    }
    public void printExams(){
        System.out.println("---- EXAMS ----");
        for(UniExam exam : uniExams.getList()){
            System.out.println(exam);
        }
    }
    public void printStudySessions(){
        System.out.println("---- STUDY SESSIONS ----");
        for(StudySession session : studySessions.getList()){
            System.out.println(session);
        }
    }
    public void printAll(){
        printTasks();
        printExams();
        printStudySessions();
    }
}
