package com.infy.smartcontact.service;

import com.infy.smartcontact.dao.Login;
import com.infy.smartcontact.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


public interface UserService {

    public ResponseEntity<?> createNewUser(User user);

    public ResponseEntity<?> loginUser(Login login);
}
