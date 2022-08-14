package com.pensionerDetails.services;

import com.pensionerDetails.model.User;

public interface UserDetailsService {


    public boolean getValidUser(String username, String password);
    public User getUserdetails(String username);

}
