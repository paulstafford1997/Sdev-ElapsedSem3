package test;

import JPAService.JPAService;
import cinemasystem.Booking;
import java.util.Scanner;
import cinemasystem.Film;
import cinemasystem.Premium;
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
                
                case 3:
                    Booking b1;
                    jpa.addBooking(new Booking());
                    System.out.println("How many tickets would you like?:");
                    int numTickets = scanner.nextInt();
                    for(int i = 0; i < numTickets; i++){ 
                        System.out.println("Ticket " + i+1);
                        System.out.println("Would you like a premium ticket?(1 for Yes, 0 for No):");
                        int premium = scanner.nextInt();
                        boolean popcorn;
                        boolean drink;
                        int number;
                        if(premium == 1){
                            Premium p1;
                            popcorn = true;
                            drink = true;
//                            jpa.getSeatNumber();
                            jpa.addPremium(new Premium(popcorn, drink, 5, 6));

                        }
                        else{
                         

                        }
                    }
                        
                case 4:
                    System.out.println("Please select ID of the film you wish create a screening for");
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
                        jpa.showScreenings();
                        int scrID = scanner.nextInt();
                        System.out.println("Please enter the year");
                        year = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Please enter the month of the screening");
                        month = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Please enter the day of the screening");
                        day = scanner.nextInt();
                        scanner.nextLine();
                        date = Calendar.getInstance();
                        date.set(year, month, day);
                        System.out.println("What time? hour:minutes format");
                        time = scanner.nextLine();
                        jpa.updateScreening(scrID, date, time);
                case 6: 
                        System.out.println("Please the Film ID that you want to delete");
                        int filmID = scanner.nextInt();
                        jpa.deleteFilm(filmID);
                case 7: 
                        System.out.println("Please the Screen ID that you want to delete");
                        scrID = scanner.nextInt();
                        jpa.deleteScreening(scrID);        
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
        System.out.println("6: Delete Film");
    }

    
}

