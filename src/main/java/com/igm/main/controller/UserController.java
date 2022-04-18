package com.igm.main.controller;

import com.igm.main.entities.User;
import com.igm.main.repositories.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin(origins = "http://localhost:8080")
public class UserController {

  private final UserRepository userRepository;

  @Autowired
  public UserController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @GetMapping("/users")
  public List<User> getUsers() {
    return (List<User>) userRepository.findAll();
  }

  @PostMapping("/users")
  void addUser(@RequestBody User user) {
    user.setEmail(user.getName().toLowerCase() + "@domain.com");
    userRepository.save(user);
    System.out.println(user);
  }
}
