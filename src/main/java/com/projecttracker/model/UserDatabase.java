package com.projecttracker.model;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.Buffer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;


public class UserDatabase {
    private User user;
    private static final String JSONFILEPATH = "data/<surname>.json";

    public UserDatabase(){
    }


    // writing User data into JSON file 
    public void save(User user){

        String filePath = "data/"+user.getSurname()+".json";

        try(BufferedWriter br = new BufferedWriter(new FileWriter(filePath))){
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            br.write(gson.toJson(user));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    // loading JSON file
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
    public void addExam(UniExam exam){

    }
    public void addStudySession(StudySession session){

    }

}
