package com.processPension.servicesimpl;

import com.processPension.Repositories.UserDetailsRepository;
import com.processPension.models.User;
import com.processPension.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class UserServiceImpl implements UserService {

    @Autowired
    private UserDetailsRepository userDetailsRepository;






    @Override
    public boolean getValidUser(String username, String password) {
        User user = this.userDetailsRepository.findByUsername(username);
        if(user!=null && user.getPassword()==password)
        {
            return true;
        }

        return false;
    }

    @Override
    public User getUserdetails(String username) {
        return this.userDetailsRepository.findByUsername(username);
    }



}
