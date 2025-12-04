package cs450.model;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name="packages")
public class TravelPackage {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Long id;

    public String title;
    public String description;
    public Double basePrice;
    public Double discountPercent = 0.0;

    @ManyToOne public Destination destination;
    @ManyToOne public Flight flight;
    @ManyToOne public Stay stay;

    @ManyToMany
    public List<Activity> activities = new ArrayList<>();
}
