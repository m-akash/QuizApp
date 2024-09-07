package com.akash.QuizApp.service;

import com.akash.QuizApp.model.Users;
import com.akash.QuizApp.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public ResponseEntity<Users> Register(Users user) {
        try {
            user.setPassword(encoder.encode(user.getPassword()));
            return new ResponseEntity<>(userRepository.save(user), HttpStatus.CREATED);
        } catch (Exception e) {
            e.fillInStackTrace();
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_GATEWAY);
    }
}
