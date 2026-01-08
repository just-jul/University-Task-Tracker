package com.projecttracker.model;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;


public class UserDatabase {
    private static final String JSONFILEPATH = "data/<surname>.json";

    public UserDatabase(User user){

    }


    public void toJSON(User user){
        Gson gson = new Gson();

        String json = gson.toJson(user);



    }
    public User loadFile(String surname){
        String filePath = "data/"+surname+".json";
         try (BufferedReader br = new BufferedReader(new FileReader(filePath))){
            Gson gson = new Gson();
            
            User user = gson.fromJson(br, User.class);

            return user;



        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
   
    }
    
    public void addClass(UniClass c){

    }
    public void addTask(UniTask task){

    }
    public void addExam(UNiExam exam){

    }
    public void addStudySession(StudySession session){

    }

}
