package com.authorization.serviceimpl;


import com.authorization.models.User;
import com.authorization.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {


    @Autowired
    private UserDetailsRepository repository;


    @Override
    public UserDetails loadUserByUsername(String name)
            throws UsernameNotFoundException {
        //User user = repository.findByUserName(username);
        User user = repository.findByUsername(name);
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());
    }
}