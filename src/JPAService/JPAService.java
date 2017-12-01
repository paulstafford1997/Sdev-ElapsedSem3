
package JPAService;

import cinemasystem.Film;
import java.util.List;
import javax.persistence.*;

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
    
    
    
}
