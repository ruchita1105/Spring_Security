package com.example.spring_security.Services;

import com.example.spring_security.Models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserService
{
    List<User> list = new ArrayList<>();

    public UserService()
    {
        list.add(new User("abc" ,"abc123","abc@gmail,com"));
        list.add(new User("xyz" ,"xyz123","abc@gmail,com"));
        list.add(new User("pqr" ,"pqr123","pqr@gmail,com"));
    }

    //get all users
    public List<User> getAllUsers() {
        return this.list;
    }

    //get single user
    public User getUser(String username)
    {
        return this.list.stream().filter(user -> user.getUsername().equals(username)).findAny().orElse(null);
    }

    //add new user
    public User addUser(User user)
    {
        this.list.add(user);
        System.out.println("User details: "+user.toString());
        return  user;
    }

    // update user
    public User updateUser(String username, User updatedUser) {
        for (int i = 0; i < list.size(); i++) {
            User user = list.get(i);
            if (user.getUsername().equals(username)) {
                // Check if new username is already taken
                if (updatedUser.getUsername() != null && !updatedUser.getUsername().equals(username)) {
                    // Check if the new username is unique
                    boolean usernameExists = list.stream()
                            .anyMatch(existingUser -> existingUser.getUsername().equals(updatedUser.getUsername()));
                    if (usernameExists) {
                        return null; // Return null if the username already exists
                    }
                    user.setUsername(updatedUser.getUsername()); // Update username if it's unique
                }
                // Update the rest of the fields
                user.setPassword(updatedUser.getPassword());
                user.setEmail(updatedUser.getEmail());
                return user;  // Return the updated user
            }
        }
        return null; // Return null if user was not found
    }
}
