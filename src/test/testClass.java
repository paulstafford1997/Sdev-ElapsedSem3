package test;

import JPAService.JPAService;
import cinemasystem.Booking;
import java.util.Scanner;
import cinemasystem.Film;
import cinemasystem.Screening;
import cinemasystem.Ticket;
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
                case 1: 
                    jpa.viewFilms(); 
                    break;
                    
                case 2: 
                    System.out.println("Please enter the name of the film");
                    scanner.nextLine(); //eat empty line
                    String title = scanner.nextLine();
                    System.out.println("Please enter the director of the film");
                    String director = scanner.nextLine();
                    System.out.println("Please enter a brief description of the film");
                    String desc = scanner.nextLine();
                    jpa.addFilm(new Film(title, director, desc)); 
                    break;
                
                case 3:
                    Booking b1 = new Booking();
                    jpa.addBooking(b1);
                    System.out.println("How many tickets would you like?:");
                    int numTickets = scanner.nextInt();
                    for(int i = 0; i < numTickets; i++){ 
                        System.out.println("Ticket " + (i+1));
                        boolean popcorn;
                        boolean drink;
                        int number;            
                        jpa.viewFilmList();
                        System.out.println("Please pick a movie: ");
                        int selection = scanner.nextInt();
                        jpa.showScreeningsByFilm(selection);
                        System.out.println("Please pick a screening: ");
                        int scrID = scanner.nextInt();
                        System.out.println("Would you like popcorn?(1 for Yes, 0 for No):");
                        int getPopcorn = scanner.nextInt();
                        if(getPopcorn == 1){
                            popcorn = true;
                        }
                        else{
                            popcorn = false;
                        }
                        System.out.println("Would you like a drink?(1 for Yes, 0 for No):");
                        int getDrink = scanner.nextInt();
                        if(getDrink == 1){
                            drink = true;
                        }
                        else{
                            drink = false;
                        }
                        double cost = 12.50;
                        Ticket t1 = new Ticket(popcorn, drink, jpa.getSeatNumber(scrID), scrID, cost);
                        jpa.addTicket(t1);
                        jpa.addTicketToBooking(b1.getId(), t1.getTid());
                        System.out.println("Thank you! Your booking reference is: " + b1.getId());
                    }
                    break;
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
                    break;
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
                    break;
                    
                case 6: 
                    jpa.viewFilmList();
                    System.out.println("Please enter the Film ID that you want to delete");
                    int filmID = scanner.nextInt();
                    jpa.deleteFilm(filmID);
                    break;
                    
                case 7:
                    jpa.showScreenings();
                    System.out.println("Please enter the Screen ID that you want to delete");
                    scrID = scanner.nextInt();
                    jpa.deleteScreening(scrID);
                    break;
                    
                case 8:
                    System.out.println("Please enter your booking reference number: ");
                    int option = scanner.nextInt();
                    jpa.showBookingReference(option);
                    break;
                
                case 9:
                    running = false;
            }
        }
        
        System.out.println("Goodbye");
        
    }
    
    public static void printMenu(){
        System.out.println("<><><| MENU |><><>");
        System.out.println("1: All movies showing");
        System.out.println("2: Add movie");
        System.out.println("3: Create Booking and add tickets");
        System.out.println("4: Create New Screening");
        System.out.println("5: Update Screening");
        System.out.println("6: Delete Film");
        System.out.println("7: Delete Screening");
        System.out.println("8: Show Booking");
        System.out.println("9: Exit");
    }

    
}

