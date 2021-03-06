
package JPAService;

import cinemasystem.Booking;
import cinemasystem.Screening;
import cinemasystem.Film;
import cinemasystem.Ticket;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import java.util.Calendar;

public class JPAService {
    
    EntityManagerFactory emf;
    EntityManager em;
        
    public JPAService()
    {
        emf = Persistence.createEntityManagerFactory("cinemaPU");
        em = emf.createEntityManager();
    }
    
    public void viewFilms()
    {
    em.getTransaction().begin();
        TypedQuery<Film> q = em.createQuery("select f from Film f order by f.filmID", Film.class);
        List<Film> results = q.getResultList();
        if (results.isEmpty()) 
        {
            System.out.println("No Films showing");
        } 
        else 
        {
            System.out.println("Films \n");
            for(Film f: results){
                System.out.println(f);
            }
        }
        em.getTransaction().commit();
    }
    
    public void addFilm(Film f) {
        em.getTransaction().begin();
        em.persist(f);
        em.getTransaction().commit();
    }
    
    public void viewFilmList(){
        em.getTransaction().begin();
        TypedQuery<Film> q = em.createQuery("select f from Film f order by f.filmID", Film.class);
        List<Film> results = q.getResultList();
        if (results.isEmpty()) 
        {
            System.out.println("No Films showing");
        } 
        else 
        {
            
            for(Film f: results){
                System.out.println(f.getFilmID() + ": " + f.getTitle());
            }
        }
        em.getTransaction().commit();
    }
    
    public void addScreening(Screening screen) {
        em.getTransaction().begin();
        em.persist(screen);
        em.getTransaction().commit();
    }
    
    public void showScreenings(){
        em.getTransaction().begin();
        TypedQuery<Screening> q = em.createQuery("select S from Screening s order by s.screeningID", Screening.class);
        List<Screening> results = q.getResultList();
        if (results.isEmpty()) 
        {
            System.out.println("No Screenings available");
        }
        else 
        {
            for(Screening s: results){
                Film f = em.find(Film.class, s.getFilmID()); //Every Screen has a film ID but not films title. search for Film Entity with that id to display films name rather than ID in the next line.
                System.out.printf("Screen ID: " + s.getScreeningID() + " " + f.getTitle() + " ");
                System.out.println(s);
            }
        }
        em.getTransaction().commit();
    }
    
    public void updateScreening(int scrID, Calendar calender, String time){
        em.getTransaction().begin();
        Screening s = em.find(Screening.class, scrID);
        s.setsDate(calender);
        s.setsTime(time);
        em.getTransaction().commit();
    }
    
    public boolean isScreeningFull(int scrID){
        boolean temp = false;
        
        em.getTransaction().begin();
        Screening s = em.find(Screening.class, scrID);
        if(s.getSeatCount() < 64){
            temp = true;
        }
        em.getTransaction().commit();
        
        return temp;
    }
    
    public void addBooking(Booking b) {
        em.getTransaction().begin();
        em.persist(b);
        em.getTransaction().commit();
    }
    
    public void addTicket(Ticket t){
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();
    }
    
    public int getSeatNumber(int scrID){
        em.getTransaction().begin();
        Screening s = em.find(Screening.class, scrID);
        int currSeat = s.getSeatCount();
        
        s.setSeatCount((currSeat + 1)); //increments seatNumber for screening
        em.getTransaction().commit();
        
        return currSeat; //returns the current seat number before incrementation
    }
    
    public void deleteFilm(int filmID) {
        em.getTransaction().begin();
        Film f = em.find(Film.class, filmID);
        em.remove(f);
        em.getTransaction().commit();
    }
    
    public void deleteScreening(int scrID) {
        em.getTransaction().begin();
        Screening s = em.find(Screening.class, scrID);
        em.remove(s);
        
        
        em.getTransaction().commit();
    }
        
    public void showScreeningsByFilm(int film){
        em.getTransaction().begin();
        TypedQuery<Screening> q = em.createQuery("select S from Screening s WHERE s.filmID = :filmID",Screening.class);
        q.setParameter("filmID",film);
        List<Screening> results = q.getResultList();
        if (results.isEmpty()) 
        {
            System.out.println("No Screenings available");
        }
        else 
        {
            for(Screening s: results){
                System.out.printf("Screen ID: " + s.getScreeningID());
                System.out.println(s);
            }
        }
        em.getTransaction().commit();
    }
    
    public void addTicketToBooking(int bookingID, int ticketID) {
        em.getTransaction().begin();
        Ticket t = em.find(Ticket.class, ticketID);
        Booking b = em.find(Booking.class, bookingID);
        b.addTicket(t);
        em.getTransaction().commit();
    }
    
    public void showBookingReference(int bookingID){
        em.getTransaction().begin();
        Booking b = em.find(Booking.class, bookingID);
            List<Ticket> tlist = b.getTlist(); //get all the tickets in the booking
                for(Ticket t: tlist){
                    Screening s = em.find(Screening.class, t.getScrID()); //gets screening from ticket
                    Film f = em.find(Film.class, s.getFilmID()); // gets Film from screening
                    System.out.println(f.getTitle()); // gets title from film
                    System.out.println(t);
                }
        em.getTransaction().commit();
    }
    
     
    
}
