package com.example.web1.service;

import com.example.web1.model.MyUserDetails;
import com.example.web1.model.User;
import com.example.web1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s){
        User user = userRepository.findByEmail(s);

        //user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + s));

        //return user.map(MyUserDetails::new).get();


        if (user == null) {
            throw new UsernameNotFoundException("Email does not exist.");
        }
        return new MyUserDetails(user);
    }

    public User getUserbyEmail(String s){
        return userRepository.findByEmail(s);
    }
}
