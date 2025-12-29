package com.projecttracker;

import java.util.ArrayList;

public class App
{
    public static void main( String[] args )
    {
        Repository<User> users = new Repository<>();
        ArrayList<User> userList = users.getList();

        userList.add(new User("John", "Krasinski", 2));
        userList.add(new User("Jenna", "Fisher", 2));
        userList.add(new User("Rainn", "Wilson", 2));

        UniClass math = new UniClass("Mathematics", "1111", "John Doe");
        UniClass databases = new UniClass("Databases", "1112", "Mark Doe");
        UniClass oop = new UniClass("Object Oriented Programming", "1113", "Lucas Doe");
        UniClass dataStructures = new UniClass("Data Structures", "1114", "Ted Doe");

        for(User  u : userList){
            u.addClass(math);
            u.addClass(oop);
            u.addClass(dataStructures);
        }

        UI ui = new UI(userList);

        for(User u : userList){
            System.out.println(u.getSurname());
        }

        ui.logIn();


    }
}
