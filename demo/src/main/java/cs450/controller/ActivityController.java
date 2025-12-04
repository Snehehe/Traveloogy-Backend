package cs450.controller;

import cs450.model.Activity;
import cs450.model.Destination;
import cs450.repository.ActivityRepository;
import cs450.repository.DestinationRepository;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/activities")
@CrossOrigin
public class ActivityController {

    private final ActivityRepository repo;
    private final DestinationRepository destRepo;

    public ActivityController(ActivityRepository repo, DestinationRepository destRepo) {
        this.repo = repo;
        this.destRepo = destRepo;
    }

    @PostMapping
    public Activity create(@RequestBody Activity a) {
        if (a.destination != null && a.destination.id != null) {
            a.destination = destRepo.findById(a.destination.id).orElse(null);
        }
        return repo.save(a);
    }
}
