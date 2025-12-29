package com.projecttracker;

import java.util.ArrayList;

public class User {
    private String name;
    private String surname;
    private int semester;
    private ArrayList<UniClass> classes;

    public User(String name, String surname, int semester){
        this.name = name;
        this.surname = surname;
        this.semester = semester;
        this.classes = new ArrayList<UniClass>();
    }
    public String getName(){
        return this.name;
    }
    public String getSurname(){
        return this.surname;
    }
    public int getSemester(){
        return this.semester;
    }
    public ArrayList<UniClass> getClasses(){
        return this.classes;
    }
    public void addClass(UniClass c){
        this.getClasses().add(c);
    }
    public UniClass findClass(String c){
        for(UniClass uniclass : classes){
            if(uniclass.getClassName().equalsIgnoreCase(c)){
                return uniclass;
            }
        }
        return null;
    }
    public void printClasses(){
        for(UniClass c : this.classes){
            System.out.println(c);
        }
    }
    public void printAll(){
        for(UniClass c : this.classes){
            System.out.println(c);
            c.printAllForThisClass();
            System.out.println("\n");
        }
    }
}
