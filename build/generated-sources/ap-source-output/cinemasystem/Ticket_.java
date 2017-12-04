package cinemasystem;

import cinemasystem.Booking;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-04T17:01:03")
@StaticMetamodel(Ticket.class)
public class Ticket_ { 

    public static volatile SingularAttribute<Ticket, Integer> rowNo;
    public static volatile SingularAttribute<Ticket, Double> cost;
    public static volatile SingularAttribute<Ticket, Boolean> popcorn;
    public static volatile ListAttribute<Ticket, Booking> blist;
    public static volatile SingularAttribute<Ticket, Integer> screeningID;
    public static volatile SingularAttribute<Ticket, Integer> seatNo;
    public static volatile SingularAttribute<Ticket, Integer> tid;
    public static volatile SingularAttribute<Ticket, Boolean> drink;

}