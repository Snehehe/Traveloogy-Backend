package cs450.controller;

import cs450.model.*;
import cs450.repository.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    private final ReviewRepository repo;
    private final UserRepository userRepo;
    private final TravelPackageRepository pkgRepo;

    public ReviewController(ReviewRepository repo, UserRepository userRepo, TravelPackageRepository pkgRepo) {
        this.repo = repo;
        this.userRepo = userRepo;
        this.pkgRepo = pkgRepo;
    }

    @GetMapping
    public List<Review> all() {
        return repo.findAll();
    }

    static class CreateReviewRequest {
        public Long userId;
        public Long packageId;
        public int rating;
        public String comment;
    }

    @PostMapping
    public Review create(@RequestBody CreateReviewRequest req) {
        UserAccount user = userRepo.findById(req.userId).orElseThrow();
        TravelPackage pkg = pkgRepo.findById(req.packageId).orElseThrow();
        return repo.save(new Review(user, pkg, req.rating, req.comment));
    }
}
