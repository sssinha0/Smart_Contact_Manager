package com.infy.smartcontact.controller;

import com.infy.smartcontact.dao.ErrorReponse;
import com.infy.smartcontact.dao.Login;
import com.infy.smartcontact.dao.Signup;
import com.infy.smartcontact.model.User;
import com.infy.smartcontact.service.UserService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;



@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {
    private ModelMapper modelMapper=new ModelMapper();
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @PostMapping("/signup")
    private ResponseEntity<?> createNewUser(@Valid @RequestBody Signup signup){
        System.out.println(signup);
        User user=modelMapper.map(signup, User.class);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userService.createNewUser(user);
    }
    @PostMapping("/login")
    private ResponseEntity<?> loginUser(@Valid @RequestBody Login login){
        User user=modelMapper.map(login,User.class);
        return userService.loginUser(login);
    }
    @GetMapping("/user")
    private ResponseEntity<?> simpleTest(){
    return ResponseEntity.ok().body(new ErrorReponse("Hello this is testing"));
    }
}
