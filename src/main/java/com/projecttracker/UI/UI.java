package com.projecttracker.UI;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

import com.projecttracker.model.StudySession;
import com.projecttracker.model.UniClass;
import com.projecttracker.model.UniExam;
import com.projecttracker.model.UniTask;
import com.projecttracker.model.User;

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
            }
        }

        System.out.println("Incorrect last name, try again.");
    }
    public void start(){
        System.out.println("-----University Calendar-----");

        while(true){
            System.out.println("MENU: ");
            System.out.println("1. Show all.");
            System.out.println("2. Add task.");
            System.out.println("3. Find and delete/mark done task.");
            System.out.println("4. Show all tasks.");
            System.out.println("5. Add exam.");
            System.out.println("6. Find and delete/mark done exam.");
            System.out.println("7. Show all exams.");
            System.out.println("8. Add study session.");
            System.out.println("9. Find and delete/mark done study session.");
            System.out.println("10. Show all study sessions.");
            System.out.println("11. Exit.");
            
            int choice = Integer.valueOf(scanner.nextLine());
            if(choice == 12){
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
                    System.out.println("FIND TASK: ");

                    UniClass foundClass = getClassFromUser();
                    System.out.println("Enter task you want to find: ");
                    String taskInput = scanner.nextLine();
    
                    foundClass.findTask(taskInput);

                    System.out.println("Press D to delete / M to mark done: ");
                    String input = scanner.nextLine();

                    if(input.equalsIgnoreCase("D")){
                        foundClass.deleteTaskByName(taskInput);
                        break;
                    }else if(input.equalsIgnoreCase("M")){
                        foundClass.getTask(taskInput).markDone();
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
                    System.out.println("FIND EXAM: ");
                    UniClass foundClass = getClassFromUser();
                    System.out.println("Enter topic of the exam you want to find: ");
                    String examInput = scanner.nextLine();

                    foundClass.findExam(examInput);

                    System.out.println("Press D to delete / M to mark done: ");
                    String input = scanner.nextLine();
                    if(input.equalsIgnoreCase("D")){
                        foundClass.deleteExamByName(examInput);
                        break;
                    }else if(input.equalsIgnoreCase("M")){
                        foundClass.getExam(examInput).markDone();
                    }
                    break;

                }
                case 7: {
                    for(UniClass c : loggedInUser.getClasses()){
                        System.out.println(c.getClassName());
                        if(c.getExamList().isEmpty()){
                            System.out.println("No exams for this class.");
                        }
                        c.printExams();
                    }
                }
                case 8: {
                    System.out.println("ADDING STUDY SESSION: ");

                    UniClass foundClass = getClassFromUser();
                    System.out.println("Enter exam title: ");
                    String examInput = scanner.nextLine();

                    LocalDate date = getDateFromUser();
                    LocalTime time = getTimeFromUser();

                    System.out.println("Enter duration (in minutes): ");
                    int duration = Integer.valueOf(scanner.nextLine());

                    StudySession newSession = new StudySession(examInput, date, time, duration, foundClass);

                    foundClass.addStudySession(newSession);

                    break;
                }
                case 9: {
                    System.out.println("FIND STUDY SESSION: ");

                    UniClass foundClass = getClassFromUser();
                    System.out.println("Enter study session name: ");
                    String sessionInput = scanner.nextLine();

                    foundClass.findStudySession(sessionInput);

                    System.out.println("Press D to delete / M to mark done: ");
                    String input = scanner.nextLine();
                    if(input.equalsIgnoreCase("D")){
                        foundClass.deleteSessionByName(sessionInput);
                        break;
                    }else if(input.equalsIgnoreCase("M")){
                        foundClass.getSession(sessionInput);
                    }
                    break;
                }
                case 10 :{
                    for(UniClass c : loggedInUser.getClasses()){
                        System.out.println(c.getClassName());
                        if(c.getStudySessions().isEmpty()){
                            System.out.println("No sessions for this class.");
                        }
                        c.printStudySessions();;
                    }
                    break;
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
