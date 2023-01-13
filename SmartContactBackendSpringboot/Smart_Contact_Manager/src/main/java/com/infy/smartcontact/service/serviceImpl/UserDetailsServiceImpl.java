package com.infy.smartcontact.service.serviceImpl;

import com.infy.smartcontact.model.User;
import com.infy.smartcontact.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Optional<User>  userDetails = userRepository.findByUsername(username);

       if (!userDetails.isPresent()){
           throw new UsernameNotFoundException("User Not found ");
       }
       return userDetails.get();
    }
}
