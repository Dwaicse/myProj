package com.authorization.service;


import com.authorization.models.User;

public interface UserDetailsService {


    public boolean getValidUser(String username, String password);
    public User getUserdetails(String username);

}
