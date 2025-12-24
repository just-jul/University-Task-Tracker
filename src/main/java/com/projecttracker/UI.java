package com.projecttracker;

import java.util.ArrayList;
import java.util.Scanner;

public class UI {
    private Scanner scanner;
    private ArrayList<User> userList;

    public UI(Scanner scanner, ArrayList userList){
        this.scanner = new Scanner(System.in);
        this.userList = new ArrayList<>();
    }

    public void start(){
        System.out.println("Enter surname: ");
        String surname = scanner.nextLine();

        for(User u : this.userList){
            if(u.getSurname() == surname){
                System.out.println("Welcome!");
                System.out.println("-----University Calendar-----");
            }
        }
    }
}
