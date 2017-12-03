package cinemasystem;

import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-03T18:06:22")
@StaticMetamodel(Screening.class)
public class Screening_ { 

    public static volatile SingularAttribute<Screening, Calendar> sDate;
    public static volatile SingularAttribute<Screening, Integer> filmID;
    public static volatile SingularAttribute<Screening, Integer> screeningID;
    public static volatile SingularAttribute<Screening, String> sTime;
    public static volatile SingularAttribute<Screening, Integer> seatCount;

}