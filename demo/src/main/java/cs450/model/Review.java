package cs450.model;

import jakarta.persistence.*;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @ManyToOne
    public UserAccount user;

    @ManyToOne
    public TravelPackage travelPackage;

    public int rating;
    public String comment;

    public Review() {}

    public Review(UserAccount user, TravelPackage travelPackage, int rating, String comment) {
        this.user = user;
        this.travelPackage = travelPackage;
        this.rating = rating;
        this.comment = comment;
    }
}
