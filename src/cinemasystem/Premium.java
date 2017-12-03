/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinemasystem;

/**
 *
 * @author pauls
 */
public class Premium extends Ticket{
    private final double cost = 24.50;
    
    public Premium(boolean popcorn, boolean drink, int number){
        super(popcorn, drink, number);
    }
    
    //mod 8 = rowNo divided by 8 for seatNo
}
