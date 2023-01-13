package com.infy.smartcontact.service.serviceImpl;

import com.infy.smartcontact.dao.ErrorReponse;
import com.infy.smartcontact.dao.Login;
import com.infy.smartcontact.model.User;
import com.infy.smartcontact.repository.UserRepository;
import com.infy.smartcontact.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public ResponseEntity<?> createNewUser(User user) {
        Optional<User> user2=userRepository.findByUsername(user.getUsername());
        if(user2.isPresent()){
            return ResponseEntity.badRequest().body(new ErrorReponse("User Alread Exists"));
        }else {
            User user1 = userRepository.save(user);
            if (user1 != null) {
                return ResponseEntity.status(200).body(user1);
            }
            return ResponseEntity.badRequest().body(new ErrorReponse("User Signup Falied"));
        }
    }

    @Override
    public ResponseEntity<?> loginUser(Login login) {
        Optional<User> user= userRepository.findByUsername(login.getUsername());
        if(user.isPresent()){
            if(user.get().getPassword().equals(login.getPassword())){
                return ResponseEntity.ok().body(new ErrorReponse("User Login Scuess"));
            }else{
                return ResponseEntity.status(400).body(new ErrorReponse("Please Enter correct Password"));

            }
        }
        return ResponseEntity.status(400).body(new ErrorReponse("User Not found please Enter correct username"));
    }
}
