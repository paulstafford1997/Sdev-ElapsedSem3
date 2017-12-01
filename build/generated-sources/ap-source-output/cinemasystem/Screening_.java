package cinemasystem;

import cinemasystem.Seat;
import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-01T15:12:30")
@StaticMetamodel(Screening.class)
public class Screening_ { 

    public static volatile SingularAttribute<Screening, Calendar> sDate;
    public static volatile SingularAttribute<Screening, Integer> filmID;
    public static volatile SingularAttribute<Screening, Integer> screeningID;
    public static volatile ListAttribute<Screening, Seat> sList;
    public static volatile SingularAttribute<Screening, String> sTime;

}