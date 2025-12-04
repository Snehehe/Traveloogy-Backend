package cs450.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Flight {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String airline;
    public String departureAirport;
    public String arrivalAirport;

    public LocalDateTime departureTime;
    public LocalDateTime arrivalTime;

    public Double price;

    @ManyToOne
    public Destination destination;
}
