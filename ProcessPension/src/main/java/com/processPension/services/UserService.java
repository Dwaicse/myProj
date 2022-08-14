package com.processPension.services;


import com.processPension.models.User;

public interface UserService {


    public boolean getValidUser(String username, String password);
    public User getUserdetails(String username);

}
