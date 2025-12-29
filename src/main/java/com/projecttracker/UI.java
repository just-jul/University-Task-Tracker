package com.projecttracker;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class UI {
    private Scanner scanner;
    private ArrayList<User> userList;
    private User loggedInUser;

    public UI(ArrayList<User> userList){
        this.scanner = new Scanner(System.in);
        this.userList = userList;
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
            }else{
                System.out.println("Incorrect last name, try again.");
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
            System.out.println("5. Find exam.");
            System.out.println("6. Add study session.");
            System.out.println("7. Find study session.");
            System.out.println("8. Exit.");
            
            int choice = Integer.valueOf(scanner.nextLine());
            if(choice == 6){
                break;
            }

            switch (choice) {
                case 1:
                loggedInUser.printAll();
                    break;
                case 2:
                    String classInput = "";
                    UniClass foundClass = null;
                    while(foundClass == null){
                        System.out.println("Enter subject: ");
                        classInput = scanner.nextLine();
                        foundClass = loggedInUser.findClass(classInput);

                        if(foundClass == null){
                            System.out.println("Class doesn't exist. Try again.");
                        }
                    
                    }
                    System.out.println("Enter task: ");
                    String task = scanner.nextLine();

                    System.out.print("Enter due date (yyyy-MM-dd): ");
                    String dateInput = scanner.nextLine();
                    LocalDate date = LocalDate.parse(dateInput);

                    UniTask newTask = new UniTask(task, date, foundClass);
                    foundClass.addUniTask(newTask);

                    break;
                case 3:
                    System.out.println("Enter task you want to find: ");
                    String taskInput = scanner.nextLine();
                    System.out.println("Enter subject: ");
                    String inputClass = scanner.nextLine();
                    

                
                default:
                    break;
            }
        }
    }
}
