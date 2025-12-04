package cs450.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String email;
    public String first_name;
    public String last_name;
    public String password;
    public String role; // USER or ADMIN

    @ManyToMany
    @JoinTable(
            name = "saved_packages",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "package_id")
    )
    public List<TravelPackage> savedPackages = new ArrayList<>();
}
