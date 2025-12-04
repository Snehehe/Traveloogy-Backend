package cs450.controller;

import cs450.model.Destination;
import cs450.model.TravelPackage;
import cs450.repository.DestinationRepository;
import cs450.repository.TravelPackageRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/packages")
@CrossOrigin("*")
public class PackageController {

    private final TravelPackageRepository packageRepo;
    private final DestinationRepository destinationRepo;

    public PackageController(TravelPackageRepository p, DestinationRepository d) {
        this.packageRepo = p;
        this.destinationRepo = d;
    }

    @PostMapping
    public TravelPackage create(@RequestBody TravelPackage pkg) {

        // ⭐ SAFETY CHECK (no nulls)
        if (pkg.destination == null || pkg.destination.id == null) {
            throw new IllegalArgumentException("Destination ID cannot be null");
        }

        // ⭐ Load real destination entity
        Destination dest = destinationRepo.findById(pkg.destination.id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid destination ID"));

        // ⭐ Reassign proper object
        pkg.destination = dest;

        return packageRepo.save(pkg);
    }

    @GetMapping
    public Iterable<TravelPackage> all() {
        return packageRepo.findAll();
    }
}
