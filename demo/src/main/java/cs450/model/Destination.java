package cs450.model;

import jakarta.persistence.*;

@Entity
public class Destination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String name;
    public String country;
    public String region;
    public String description;

    public Destination() {}

    public Destination(String name, String country, String region, String description) {
        this.name = name;
        this.country = country;
        this.region = region;
        this.description = description;
    }

    public Destination(long l, String string, String string2, String string3, String string4) {
        //TODO Auto-generated constructor stub
    }
}
