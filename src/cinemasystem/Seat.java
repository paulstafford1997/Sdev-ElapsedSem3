/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinemasystem;

import javax.persistence.*;

@Entity
@Table (name="Seat")
@SequenceGenerator(name = "seat_seq", initialValue = 1, allocationSize = 1)
@SuppressWarnings("SerializableClass")
public class Seat {
    
    @Id
    int seatID;
    String status;
    
    public Seat(){
        status = "available";
    }
    
    
}
