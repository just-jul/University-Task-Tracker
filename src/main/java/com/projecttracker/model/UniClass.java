package com.projecttracker.model;

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

    // ---- TASK methods ----
    public ArrayList<UniTask> getUniTasks(){
        ArrayList<UniTask> uniTaskList = this.uniTasks.getList();
        return uniTaskList;
    }
    public void findTask(String taskName){
        for(UniTask task : this.getUniTasks()){
            if(task.getTaskName().equalsIgnoreCase(taskName)){
                System.out.println(task);
            }else{
                System.out.println("Task doesn't exist.");
            }
        }
    }
    public UniTask getTask(String taskName){
        for(UniTask task : this.getUniTasks()){
            if(task.getTaskName().equalsIgnoreCase(taskName)){
                return task;
            }else{
                System.out.println("Error");
            }
        }
        return null;
    }
    public void addUniTask(UniTask task){
        ArrayList<UniTask> uniTaskList = this.uniTasks.getList();
        uniTaskList.add(task);
    }
    public void deleteTaskByName(String taskName){
        ArrayList<UniTask> uniTaskList = this.uniTasks.getList();
        this.findTask(taskName);
        uniTaskList.removeIf(task -> task.getTaskName().equalsIgnoreCase(taskName));
        System.out.println("\nTask deleted successfully.");
    }

    // ---- EXAM methods ----
    public ArrayList<UniExam> getExamList(){
        ArrayList<UniExam> examList = this.uniExams.getList();
        return examList;
    }
    public void addExam(UniExam exam){
        ArrayList<UniExam> examList = this.uniExams.getList();
        examList.add(exam);
    }
    public void deleteExamByName(String examName){
        ArrayList<UniExam> examList = this.uniExams.getList();

        this.findExam(examName);

        examList.removeIf(exam -> exam.getTaskName().equalsIgnoreCase(examName));
        System.out.println("Exam deleted successfully.");
    }
    public void findExam(String examName){
        for(UniExam exam : this.getExamList()){
            if(exam.getTaskName().equalsIgnoreCase(examName)){
                System.out.println(exam);
            }else{
                System.out.println("Exam doesn't exist.");
            }
        }
    }
    public UniExam getExam(String examName){
        for(UniExam exam : this.getExamList()){
            if(exam.getTaskName().equalsIgnoreCase(examName)){
                return exam;
            }else{
                System.out.println("Error");
            }
        }
        return null;
    }

    // ---- STUDY SESSION methods ---- 
    public ArrayList<StudySession> getStudySessions(){
        ArrayList<StudySession> studySessionList = this.studySessions.getList();
        return studySessionList;
    }
    public void addStudySession(StudySession session){
        ArrayList<StudySession> studySessionList = this.studySessions.getList();
        studySessionList.add(session);
    }
    public void deleteStudySession(StudySession session){
        ArrayList<StudySession> studySessionList = this.studySessions.getList();
        studySessionList.remove(session);
    }
    public void deleteSessionByName(String sessionName){
        ArrayList<StudySession> studySessionList = this.studySessions.getList();
        this.findStudySession(sessionName);
        studySessionList.removeIf(session -> session.getTaskName().equalsIgnoreCase(sessionName));
        System.out.println("Session deleted successfully.");

    }
    public void findStudySession(String sessionName){
        for(StudySession session : this.getStudySessions()){
            if(session.getTaskName().equalsIgnoreCase(sessionName)){
                System.out.println(session);
            }else{
                System.out.println("Study session doesn't exist.");
            }
        }
    
    }
    public UniExam getSession(String sessionName){
        for(StudySession s : this.getStudySessions()){
            if(s.getTaskName().equalsIgnoreCase(sessionName)){
                return s;
            }else{
                System.out.println("Error");
            }
        }
        return null;
    }

    public void printTasks(){
        System.out.println("---- TASKS ----");
        for(UniTask task : getUniTasks()){
            System.out.println(task);
        }
    }
    public void printExams(){
        System.out.println("---- EXAMS ----");
        for(UniExam exam : getExamList()){
            System.out.println(exam);
        }
    }
    public void printStudySessions(){
        System.out.println("---- STUDY SESSIONS ----");
        for(StudySession session : getStudySessions()){
            System.out.println(session);
        }
    }
    public void printAllForThisClass(){
        printTasks();
        printExams();
        printStudySessions();
    }

    @Override
    public String toString(){
        return "Class name: "+this.getClassName()+"\n"+
        "Teacher: "+this.getTeacher()+"\n\n";
    }
}
