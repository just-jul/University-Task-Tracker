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
    }
    public String getName(){
        return this.name;
    }
    public String getSurname(){
        return this.surname;
    }
}
