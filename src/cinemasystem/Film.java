
package cinemasystem;

import java.util.ArrayList;
import javax.persistence.*;
import java.util.List;

/**
 *
 * @author Kilian
 */
@Entity
@Table (name="Film")
@SequenceGenerator(name = "film_seq", initialValue = 1, allocationSize = 1)
@SuppressWarnings("SerializableClass")
public class Film {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "film_seq")
    int filmID;
    String title;
    String director;
    String description;
    
    @JoinColumn(name ="filmID")
    @OneToMany(cascade = CascadeType.ALL)
    private List<Screening> scrList = new ArrayList<>();
    
    public Film(){
        
    }
    
    public Film(String title, String director, String description){
        this.title = title;
        this.director = director;
        this.description = description;
    }

    public int getFilmID() {
        return filmID;
    }

    public void setFilmID(int filmID) {
        this.filmID = filmID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public String toString(){
        System.out.println(filmID + ": " +  title);
        for(Screening s: scrList){
            System.out.println(s);
        }
        return " \nDirector: " + director + "\n" + description + "\n --------------------------"; 
    }

    public List<Screening> getScrList() {
        return scrList;
    }

    public void setScrList(List<Screening> scrList) {
        this.scrList = scrList;
    }
    
}
