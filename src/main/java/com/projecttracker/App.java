package com.projecttracker;

import java.util.ArrayList;

public class App
{
    public static void main( String[] args )
    {
        Repository<User> users = new Repository<>();
        ArrayList<User> userList = users.getList();

        userList.add(new User("John", "Krasinski", 2));
        userList.add(new User("Jenna", "Fisher", 4));
        userList.add(new User("Rainn", "Wilson", 2));

        


    }
}
