package com.goat.thegoat.service;

import com.goat.thegoat.model.User;
import com.goat.thegoat.model.UserRoles;

import java.util.Set;

public interface UserService {

    //create a user
    public User createUser(User user, Set<UserRoles> userRoles) throws Exception;

    public User getUser(String username) throws Exception;
}
