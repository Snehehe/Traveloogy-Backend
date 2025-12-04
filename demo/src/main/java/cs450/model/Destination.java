package cs450.model;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class Destination {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String name;
    public String country;
    public String region;
    public String climate;
    public String bestSeason;
    public Double avgBudget;
    public String tags;

    @ElementCollection
    public List<String> photoUrls = new ArrayList<>();
}
