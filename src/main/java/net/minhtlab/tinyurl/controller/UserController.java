package net.minhtlab.tinyurl.controller;

import net.minhtlab.tinyurl.dao.UserRepository;
import net.minhtlab.tinyurl.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userDao;

    @PostMapping("/")
    public ResponseEntity<Long> createUser(@RequestBody Map<String, String> body) {
        try {
            User user = new User();
            user.setEmail(body.get("email"));
            user.setName(body.get("name"));

            user = userDao.save(user);
            return ResponseEntity.ok().body(user.getId());
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(-1L);
        }
    }

    @GetMapping
    public List<User> getUsers() {
        return userDao.findAll();
    }
}
