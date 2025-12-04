package cs450.model;

import jakarta.persistence.*;

@Entity
public class Stay {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String hotelName;
    public String roomType;
    public Double pricePerNight;
    public String availabilityNotes;

    @ManyToOne
    public Destination destination;
}
