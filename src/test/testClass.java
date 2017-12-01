package test;

import JPAService.JPAService;
import java.util.Scanner;
import cinemasystem.Film;

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
                
            }
        }
        
        System.out.println("Goodbye");
        
    }
    
    public static void printMenu(){
        System.out.println("<><><| MENU |><><>");
        System.out.println("1: All movies showing");
        System.out.println("2: Add movie");
    }

    
}

