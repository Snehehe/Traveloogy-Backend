package cs450.model;

import jakarta.persistence.*;

@Entity
public class Activity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String title;
    public String description;
    public Double price;

    @ManyToOne
    public Destination destination;
}
