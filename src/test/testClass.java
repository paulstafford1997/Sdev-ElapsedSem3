package test;

import JPAService.JPAService;
import java.util.Scanner;
import cinemasystem.Film;
import cinemasystem.Screening;
import java.util.Calendar;

public class testClass {
    
    static JPAService jpa = new JPAService();
    
    public static void main(String[] args)
    {
        //boolean to exit system
        boolean running = true;
        Scanner scanner = new Scanner(System.in);
        //users choice
        int choice;
        
        while(running){
            
            printMenu();
            choice = scanner.nextInt();
            //menu code
            switch(choice){
                case 1: jpa.viewFilms(); break;
                case 2:  
                        System.out.println("Please enter the name of the film");
                        scanner.nextLine(); //eat empty line
                        String title = scanner.nextLine();
                        System.out.println("Please enter the director of the film");
                        String director = scanner.nextLine();
                        System.out.println("Please enter a beif description of the film");
                        String desc = scanner.nextLine();
                        jpa.addFilm(new Film(title, director, desc)); 
                        break;
                case 4:
                        System.out.println("Please select ID of the film you wish to update");
                        jpa.viewFilmList();
                        int selection = scanner.nextInt();
                        System.out.println("Please enter the year");
                        int year = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Please enter the month of the screening");
                        int month = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Please enter the day of the screening");
                        int day = scanner.nextInt();
                        scanner.nextLine();
                        Calendar date = Calendar.getInstance();
                        date.set(year, month, day);
                        System.out.println("What time? hour:minutes format");
                        String time = scanner.nextLine();
                        jpa.addScreening(new Screening(selection, date, time));
                case 5:
                        System.out.println("Please select ID of the screening you wish to update");
                        jpa.viewFilms();
            }
        }
        
        System.out.println("Goodbye");
        
    }
    
    public static void printMenu(){
        System.out.println("<><><| MENU |><><>");
        System.out.println("1: All movies showing");
        System.out.println("2: Add movie");
        
        System.out.println("4: Create New Screening");
        System.out.println("5: Update Screening");
    }

    
}

