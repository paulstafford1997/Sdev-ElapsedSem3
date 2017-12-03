/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinemasystem;

/**
 *
 * @author Kilian
 */

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@SequenceGenerator(name = "book_seq", initialValue = 1, allocationSize = 1)
@Table(name = "Booking")
@SuppressWarnings("SerializableClass")
public class Booking {
    //needs an array list of tickets
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_seq")
    @Column(name="bookingID")
    private int id;
    
    @ManyToMany (cascade = CascadeType.PERSIST)
    @JoinTable(name="BOOKINGTICKET",
    joinColumns = @JoinColumn(name="bookingID"),
    inverseJoinColumns=@JoinColumn(name="ticketID"))
    private List<Ticket> tlist = new ArrayList<>();
    
    public Booking(){
        
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTlist(List<Ticket> tlist) {
        this.tlist = tlist;
    }

    public int getId() {
        return id;
    }

    public List<Ticket> getTlist() {
        return tlist;
    }
    
    public void addTicket(Ticket t) {
        tlist.add(t);
        t.getBlist().add(this);
    }
    
    public void removeTicket(Ticket t) {
        tlist.remove(t);
        t.getBlist().remove(this);
    }
    
    public void remove() {
        ArrayList<Ticket> temp = new ArrayList<>(tlist);
        for (int i = 0; i < temp.size(); i++) {
            removeTicket(temp.get(i));
        }
    }
    
    
   @Override
    public String toString(){
        String formattedString = String.format("Booking ID: %d", id);
        return formattedString;
    }
    
}
