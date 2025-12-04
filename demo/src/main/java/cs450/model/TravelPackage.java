package cs450.model;

import jakarta.persistence.*;

@Entity
@Table(name = "packages")
public class TravelPackage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String title;
    public String description;
    public Double basePrice;

    @ManyToOne
    @JoinColumn(name = "destination_id")
    public Destination destination;

    public TravelPackage() {}

    public TravelPackage(String title, String description, Double basePrice, Destination destination) {
        this.title = title;
        this.description = description;
        this.basePrice = basePrice;
        this.destination = destination;
    }
}
