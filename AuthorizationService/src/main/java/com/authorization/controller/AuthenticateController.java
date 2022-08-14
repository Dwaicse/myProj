package com.authorization.controller;

import com.authorization.config.JwtUtil;
import com.authorization.models.JwtRequest;


import com.authorization.models.JwtResponse;
import com.authorization.repository.UserDetailsRepository;
import com.authorization.serviceimpl.UserDetailsServiceImpl;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/authentication")
@CrossOrigin(origins = "*")

public class AuthenticateController {


    @Autowired
    private AuthenticationManager authenticationManager;


    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private UserDetailsRepository userDetailsRepository;
    @Autowired
    private JwtUtil jwtUtil;


    @RequestMapping(value = "/token", method = RequestMethod.POST)
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        System.out.println(jwtRequest);
        try {
            this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(),jwtRequest.getPassword()));

        }catch (UsernameNotFoundException e){
            e.printStackTrace();
            throw new Exception("Bad Credentials");
        }


        UserDetails user = this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());

        String token = this.jwtUtil.generateToken(user);

        System.out.println("JWT " + token);

        return ResponseEntity.ok(new JwtResponse(token));

    }




    @GetMapping("/currentUser")
    @ApiImplicitParams({
            @ApiImplicitParam(name="Authorization", value = "Token", required = true, allowEmptyValue = false,paramType = "header", dataTypeClass = String.class,example = "Bearer access_token")
    })

    public User getCurrentUser(Principal principal)
    {
        return (User) this.userDetailsService.loadUserByUsername(principal.getName());

    }



    @GetMapping("/getCurrentUser/{username}")
    @ApiImplicitParams({
            @ApiImplicitParam(name="Authorization", value = "Token", required = true, allowEmptyValue = false,paramType = "header", dataTypeClass = String.class,example = "Bearer access_token")
    })
    public com.authorization.models.User getCurrentUser(@PathVariable("username")String username)
    {
        return  this.userDetailsRepository.findByUsername(username);
    }


}
