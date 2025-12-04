package cs450.controller;

import cs450.model.User;
import cs450.model.TravelPackage;
import cs450.repository.UserRepository;
import cs450.repository.TravelPackageRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UserController {

    private final UserRepository users;
    private final TravelPackageRepository packages;

    public UserController(UserRepository users, TravelPackageRepository packages) {
        this.users = users;
        this.packages = packages;
    }

    @PostMapping("/register")
    public User register(@RequestBody User u) {
        return users.save(u);
    }

    @PostMapping("/login")
    public User login(@RequestBody User request) {
        User u = users.findByEmail(request.email);
        if (u == null || !u.password.equals(request.password)) {
            throw new RuntimeException("Invalid credentials");
        }
        return u;
    }

    @GetMapping("/{id}/saved-packages")
    public List<TravelPackage> getSavedPackages(@PathVariable Long id) {
        User u = users.findById(id).orElseThrow();
        return u.savedPackages;
    }

    @PostMapping("/{id}/save/{packageId}")
    public User savePackage(@PathVariable Long id, @PathVariable Long packageId) {
        User u = users.findById(id).orElseThrow();
        TravelPackage p = packages.findById(packageId).orElseThrow();

        if (!u.savedPackages.contains(p)) {
            u.savedPackages.add(p);
        }

        return users.save(u);
    }
}
