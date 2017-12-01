
package cinemasystem;

/**
 *
 * @author Kilian
 */
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.*;

@Entity
@SequenceGenerator(name = "scring_seq", initialValue = 1, allocationSize = 1)
@SuppressWarnings("SerializableClass")
public class Screening {
    
    @Id
    int screeningID;
    String sTime;
    int filmID;

    @Temporal(TemporalType.DATE)
    private Calendar sDate;
    
    @ManyToMany(cascade = CascadeType.PERSIST) 
    @JoinTable(name = "Seat",
            joinColumns = @JoinColumn(name = "screenID"),
            inverseJoinColumns = @JoinColumn(name = "seatID"))
    private List<Seat> sList = new ArrayList<>();
    
    public Screening(){
        
    }
    
    public Screening(int filmID, Calendar sDate, String sTime){
        this.filmID = filmID;
        this.sDate = sDate;
        this.sTime = sTime;
        
        for(int i=0; i < 16; i++){
            sList.add(new Seat());
        }
    }

    public int getFilmID() {
        return filmID;
    }

    public void setFilmID(int filmID) {
        this.filmID = filmID;
    }

    public List<Seat> getsList() {
        return sList;
    }

    public void setsList(List<Seat> sList) {
        this.sList = sList;
    }
    
    public int getScreeningID() {
        return screeningID;
    }

    public void setScreeningID(int screeningID) {
        this.screeningID = screeningID;
    }

    public String getsTime() {
        return sTime;
    }

    public void setsTime(String sTime) {
        this.sTime = sTime;
    }

    public Calendar getsDate() {
        return sDate;
    }

    public void setsDate(Calendar sDate) {
        this.sDate = sDate;
    }

    public String toString(){
        String fDate = String.format("%1$s %2$tB %2$td, %2$tY",
                " ", sDate);
        //formatting sDate
        return fDate + ": " + sTime;
    }
    
}
