package com.projecttracker;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
                return;
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
            System.out.println("4. Show all tasks.");
            System.out.println("5. Add exam.");
            System.out.println("6. Find exam.");
            System.out.println("7. Show all exams.");
            System.out.println("8. Add study session.");
            System.out.println("9. Find study session.");
            System.out.println("10. Show study sessions.");
            System.out.println("11. Exit.");
            
            int choice = Integer.valueOf(scanner.nextLine());
            if(choice == 6){
                break;
            }

            switch (choice) {
                case 1: 
                loggedInUser.printAll();
                    break;
                case 2: {
                    System.out.println("ADDING TASK: ");
                    UniClass foundClass = getClassFromUser();
                    System.out.println("Enter task: ");
                    String task = scanner.nextLine();

                    LocalDate date = getDateFromUser();

                    UniTask newTask = new UniTask(task, date, foundClass);
                    foundClass.addUniTask(newTask);

                    break;
                }
                case 3: {
                    UniClass foundClass = getClassFromUser();
                    System.out.println("Enter task you want to find: ");
                    String taskInput = scanner.nextLine();

                    ArrayList<UniTask> taskList = foundClass.getUniTasks();

                    for(UniTask task : taskList){
                        if(task.getTaskName().equalsIgnoreCase(taskInput)){
                            System.out.println(task);
                        }
                    }
                    break;
                }
                case 4: {
                    for(UniClass c : loggedInUser.getClasses()){
                        System.out.println(c.getClassName());
                        if(c.getUniTasks().isEmpty()){
                            System.out.println("No tasks for this class.");
                        }
                        c.printTasks();
                    }
                    break;
                }
                case 5: {
                    System.out.println("ADDING EXAM: ");
                    UniClass foundClass = getClassFromUser();
                    System.out.println("Enter exam title: ");
                    String examInput = scanner.nextLine();

                    LocalDate date = getDateFromUser();

                    LocalTime time = getTimeFromUser();

                    UniExam newExam = new UniExam(examInput, date, time, foundClass);
                    foundClass.addExam(newExam);

                    break;
                }
                case 6: {

                }

        
                
                default:
                    break;
            }
        }
    }

    public UniClass getClassFromUser(){
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
        return foundClass;
    }
    public LocalDate getDateFromUser(){
        LocalDate date = null;
        while(date == null){
            System.out.print("Enter due date (yyyy-MM-dd): ");
            String dateInput = scanner.nextLine();
            try {
                date = LocalDate.parse(dateInput);
                } catch (Exception e) {
                    System.out.println("Invalid date format. Try again.");
            }
        }
        return date;
    }
    public LocalTime getTimeFromUser(){
        LocalTime time = null;

        while(time == null){
            System.out.println("Enter time (HH:mm): ");
            String timeInput = scanner.nextLine();
            try {
                time = LocalTime.parse(timeInput);
            } catch (Exception e){
                System.out.println("Invalid time format. Try again.");
            }
        }
        return time;
    }
}
