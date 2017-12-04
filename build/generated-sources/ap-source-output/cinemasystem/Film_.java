package cinemasystem;

import cinemasystem.Screening;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-04T17:01:02")
@StaticMetamodel(Film.class)
public class Film_ { 

    public static volatile SingularAttribute<Film, String> director;
    public static volatile ListAttribute<Film, Screening> scrList;
    public static volatile SingularAttribute<Film, Integer> filmID;
    public static volatile SingularAttribute<Film, String> description;
    public static volatile SingularAttribute<Film, String> title;

}