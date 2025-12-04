package cs450.controller;

import cs450.model.TravelPackage;
import cs450.repository.TravelPackageRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/packages")
@CrossOrigin
public class PackageController {

    private final TravelPackageRepository repo;

    public PackageController(TravelPackageRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<TravelPackage> all() {
        return repo.findAll();
    }

    @PutMapping("/{id}")
    public TravelPackage update(@PathVariable Long id, @RequestBody TravelPackage updated) {
        TravelPackage p = repo.findById(id).orElseThrow();

        if (updated.base_price != null)
            p.base_price = updated.base_price;

        if (updated.discount_percent != null)
            p.discount_percent = updated.discount_percent;

        if (updated.title != null)
            p.title = updated.title;

        return repo.save(p);
    }
}
