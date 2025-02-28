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


}
