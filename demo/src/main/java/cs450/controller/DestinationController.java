package cs450.controller;

import cs450.model.Destination;
import cs450.repository.DestinationRepository;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/destinations")
@CrossOrigin
public class DestinationController {

    private final DestinationRepository repo;

    public DestinationController(DestinationRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Destination> all() { return repo.findAll(); }

    @PostMapping
    public Destination create(@RequestBody Destination d) { return repo.save(d); }
    
}
