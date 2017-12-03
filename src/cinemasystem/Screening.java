
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "scring_seq")
    int screeningID;
    String sTime;
    int filmID;
    int seatCount;

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }

    @Temporal(TemporalType.DATE)
    private Calendar sDate;

    public Screening(){
        
    }
    
    public Screening(int filmID, Calendar sDate, String sTime){
        this.filmID = filmID;
        this.sDate = sDate;
        this.sTime = sTime;
        
    }

    public int getFilmID() {
        return filmID;
    }

    public void setFilmID(int filmID) {
        this.filmID = filmID;
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
