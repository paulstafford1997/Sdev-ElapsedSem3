package test;

import JPAService.JPAService;
import java.util.Scanner;

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
                
            }
        }
        
        System.out.println("Goodbye");
        
    }
    
    public static void printMenu(){
        System.out.println("<><><| MENU |><><>");
        System.out.println("1: All movies showing");
    }

    
}

