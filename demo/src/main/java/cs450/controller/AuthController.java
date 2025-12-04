package cs450.controller;

import cs450.model.User;
import cs450.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {

    private final UserRepository users;

    public AuthController(UserRepository users) {
        this.users = users;
    }

    @PostMapping("/login")
    public User login(@RequestBody User input) {

        User found = users.findByEmail(input.email);

        if (found == null) {
            throw new RuntimeException("Invalid email");
        }

        if (!found.password.equals(input.password)) {
            throw new RuntimeException("Invalid password");
        }

        return found;  // Return user to frontend
    }

    @PostMapping("/register")
    public User register(@RequestBody User u) {
        return users.save(u);
    }
}
