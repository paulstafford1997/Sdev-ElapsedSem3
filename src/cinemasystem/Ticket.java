/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinemasystem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Kilian
 */

@Entity
@SequenceGenerator(name = "ticket_seq", initialValue = 1, allocationSize = 1)
@Table(name = "Ticket")
    
public class Ticket implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ticket_seq")
    @Column(name="ticketID")
    private int tid;
    private Boolean popcorn;
    private Boolean drink;
    private int screeningID;
    private int seatNo;
    private int rowNo;
    private double cost;
    
    @ManyToMany(mappedBy = "tlist",cascade =CascadeType.PERSIST)
    private List<Booking> blist = new ArrayList<>();
    
    public Ticket(){
        
    }
    
    public Ticket(boolean popcorn, boolean drink, int number, int scrID, double cost){
        this.popcorn = popcorn;
        this.drink = drink;
        this.screeningID = scrID;
        this.cost = cost;
        
        seatNo = calcSeat(number);
        rowNo = calcRow(number);
    }
    
    public void addPopcorn(){
        cost+=3.00;
    }
    
    public void addDrink(){
        cost+=2.00;
    }

    public void setScrID(int scrID) {
        this.screeningID = scrID;
    }

    public int getScrID() {
        return screeningID;
    }

    public int getTid() {
        return tid;
    }

    public boolean getPopcorn() {
        return popcorn;
    }

    public boolean getDrink() {
        return drink;
    }

    public int getSeatNo() {
        return seatNo;
    }

    public int getRowNo() {
        return rowNo;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public void setPopcorn(boolean popcorn) {
        this.popcorn = popcorn;
    }

    public void setDrink(boolean drink) {
        this.drink = drink;
    }

    public void setSeatNo(int seatNo) {
        this.seatNo = seatNo;
    }

    public void setRowNo(int rowNo) {
        this.rowNo = rowNo;
    }

    public void setBlist(List<Booking> blist) {
        this.blist = blist;
    }

    public List<Booking> getBlist() {
        return blist;
    }
    
//    public void addBooking(Booking b) {
//        blist.add(b);
//        b.getTlist().add(this);
//    }
//    
//    public void removeBooking(Booking b) {
//        blist.remove(b);
//        b.getTlist().remove(this);
//    }
//    
//    public void remove() {
//        ArrayList<Booking> temp = new ArrayList<>(blist);
//        for (int i = 0; i < temp.size(); i++) {
//            removeBooking(temp.get(i));
//        }
//    }
    
    public int calcRow(int number){
        double temp = (double)number / 8;
        return (int)Math.ceil(temp);
    }
    
    public int calcSeat(int number){
        return number % 8;
    }
    
    @Override
    public String toString() {
        String formattedString = String.format("Seat No: %d, Row No: %d, Popcorn: %b Drink: %b", seatNo, rowNo, popcorn, drink);
        return formattedString;
    }
}
