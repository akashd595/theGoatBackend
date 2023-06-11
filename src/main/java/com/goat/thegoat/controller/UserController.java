package com.goat.thegoat.controller;


import com.goat.thegoat.model.Role;
import com.goat.thegoat.model.User;
import com.goat.thegoat.model.UserRoles;
import com.goat.thegoat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @PostMapping("/create-user")
    public User createUser(@RequestBody User user) throws Exception {
        user.setProfile("default.png");
        user.setEnabled(true);
        //encoding password
        user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
        Set<UserRoles> roles = new HashSet<>();

        Role role = new Role();
        role.setRoleName("Normal");
        UserRoles ur = new UserRoles();
        ur.setUser(user);
        ur.setRole(role);
        roles.add(ur);
        return this.userService.createUser(user, roles);

    }
    @GetMapping("/username/{username}")
    public User getUSer(@PathVariable String username) throws Exception {
        System.out.println("inside /username/{username}");
        return this.userService.getUser(username);
    }

}
