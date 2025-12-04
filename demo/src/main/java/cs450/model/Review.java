package cs450.model;

import jakarta.persistence.*;

@Entity
public class Review {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public int rating;
    public String comment;

    @ManyToOne public User user;
    @ManyToOne public Destination destination;
}
