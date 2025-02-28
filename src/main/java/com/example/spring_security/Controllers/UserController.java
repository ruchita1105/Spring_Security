package com.example.spring_security.Controllers;

import com.example.spring_security.Models.User;
import com.example.spring_security.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController
{
    @Autowired
    private UserService userService;


    //all users
    @GetMapping("/getAll")
    public List<User> getAllUsers()
    {
            return this.userService.getAllUsers();
    }

    //return single username
    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username)
    {
        return  this.userService.getUser(username);

    }

    @PostMapping("/create")
    public  User add(@RequestBody User user)
    {
        return  this.userService.addUser(user);
    }
    // Update an existing user
    @PutMapping("/update/{username}")
    public User updateUser(@PathVariable("username") String username, @RequestBody User updatedUser) {
        User updated = this.userService.updateUser(username, updatedUser);
        if (updated == null) {
            // Return an error message if the username already exists
            throw new RuntimeException("Username is already taken or user not found");
        }
        return updated;
    }

}
