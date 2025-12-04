package cs450.controller;

import cs450.model.UserAccount;
import cs450.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository repo;

    public UserController(UserRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<UserAccount> all() {
        return repo.findAll();
    }

    @PostMapping
    public UserAccount create(@RequestBody UserAccount user) {
        return repo.save(user);
    }
}
