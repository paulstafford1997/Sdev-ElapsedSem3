
package JPAService;

import cinemasystem.Booking;
import cinemasystem.Screening;
import cinemasystem.Film;
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
        TypedQuery<Film> q = em.createQuery("select f from Film f", Film.class);
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
        TypedQuery<Film> q = em.createQuery("select f from Film f", Film.class);
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
        TypedQuery<Screening> q = em.createQuery("select S from Screening s", Screening.class);
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
        boolean temp;
        
        em.getTransaction().begin();
        Screening s = em.find(Screening.class, scrID);
        if(s.getSeatCount() < 64){
            temp = true;
        }
        else
        {
            temp = false;
        }
        em.getTransaction().commit();
        
        return temp;
    }
    
    public void addBooking(Booking b) {
        em.getTransaction().begin();
        em.persist(b);
        em.getTransaction().commit();
    }
    
}
