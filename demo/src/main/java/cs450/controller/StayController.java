package cs450.controller;

import cs450.model.Stay;
import cs450.repository.StayRepository;
import cs450.repository.DestinationRepository;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/stays")
@CrossOrigin
public class StayController {

    private final StayRepository stays;
    private final DestinationRepository destinations;

    public StayController(StayRepository stays, DestinationRepository destinations) {
        this.stays = stays;
        this.destinations = destinations;
    }

    @GetMapping
    public List<Stay> all() {
        return stays.findAll();
    }

    @PostMapping
    public Stay create(@RequestBody Stay s) {
        if (s.destination != null && s.destination.id != null) {
            s.destination = destinations.findById(s.destination.id).orElse(null);
        }
        return stays.save(s);
    }
}
