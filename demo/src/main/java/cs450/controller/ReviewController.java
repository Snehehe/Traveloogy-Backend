package cs450.controller;

import cs450.model.*;
import cs450.repository.*;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/reviews")
@CrossOrigin
public class ReviewController {

    private final ReviewRepository repo;
    private final UserRepository users;
    private final DestinationRepository dests;

    public ReviewController(ReviewRepository repo, UserRepository users, DestinationRepository dests) {
        this.repo = repo;
        this.users = users;
        this.dests = dests;
    }

   @PostMapping
public Review create(@RequestParam Long userId,
                     @RequestParam Long destinationId,
                     @RequestBody Review r) {

    r.user = users.findById(userId).orElseThrow();
    r.destination = dests.findById(destinationId).orElseThrow();

    return repo.save(r);
}

}
