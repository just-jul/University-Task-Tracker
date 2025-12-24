package com.projecttracker;

import java.util.ArrayList;
import java.util.Scanner;

public class UI {
    private Scanner scanner;
    private ArrayList<User> userList;
    private User loggedInUser;

    public UI(Scanner scanner, ArrayList userList){
        this.scanner = new Scanner(System.in);
        this.userList = new ArrayList<>();
        this.loggedInUser = null;
    }

    public void logIn(){
        System.out.println("Enter surname: ");
        String surname = scanner.nextLine();

        for(User u : this.userList){
            if( u.getSurname() != null && u.getSurname().equalsIgnoreCase(surname)){ // case-insesnitive check 
                this.loggedInUser = u;
                System.out.println("Welcome!");
                start();
                break;
            }
        }
    }
    public void start(){
        System.out.println("-----University Calendar-----");

        while(true){
            System.out.println("MENU: ");
            System.out.println("1. Show all.");
            System.out.println("2. Add task.");
            System.out.println("3. Find task.");
            System.out.println("4. Add exam.");
            System.out.println("5. Add study session.");
            System.out.println("6. Exit.");
            
            int choice = Integer.valueOf(scanner.nextLine());
            if(choice == 6){
                break;
            }

            switch (choice) {
                case 1:
                    
                    break;
            
                default:
                    break;
            }
        }
    }
}
