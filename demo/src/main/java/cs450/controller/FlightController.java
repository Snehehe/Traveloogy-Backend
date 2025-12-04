package cs450.controller;

import cs450.model.*;
import cs450.repository.*;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/flights")
@CrossOrigin
public class FlightController {

    private final FlightRepository flights;
    private final DestinationRepository destinations;

    public FlightController(FlightRepository flights, DestinationRepository destinations) {
        this.flights = flights;
        this.destinations = destinations;
    }

    @PostMapping
    public Flight create(@RequestBody Flight f) {
        if (f.destination != null && f.destination.id != null) {
            f.destination = destinations.findById(f.destination.id).orElse(null);
        }
        return flights.save(f);
    }

    @GetMapping
    public List<Flight> all() { return flights.findAll(); }
}
