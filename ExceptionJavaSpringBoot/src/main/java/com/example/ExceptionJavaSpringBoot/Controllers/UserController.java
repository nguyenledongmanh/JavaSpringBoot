package com.example.ExceptionJavaSpringBoot.Controllers;

import com.example.ExceptionJavaSpringBoot.Models.User;
import com.example.ExceptionJavaSpringBoot.Services.BusinessServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/User")
public class UserController {
    @Autowired
    BusinessServices businessServices;

    @GetMapping("/getUser")
    public List<User> getAllUser() {
        return businessServices.getAllUser();
    }

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user) {
        return businessServices.addUser(user);
    }

    @PutMapping("/editUser/{id}")
    public User editUser(@PathVariable String id, @RequestBody User user) {
        return businessServices.editUser(user, id);
    }

    @DeleteMapping("/deleteUser/{id}")
    public User deleteUser(@PathVariable String id) {
        return businessServices.deleteUserByID(id);
    }
}
