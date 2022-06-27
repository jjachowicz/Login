package com.example.Login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.transaction.Transactional;
import java.util.List;

@Controller
public class AuthenticationController {

    @Autowired
    private UserRepository userRepository;

    // register a new user
    // echo '{"username":"mary123", "password":"password123", "email":"mary123@email.com"}' | curl -X POST -H "Content-Type: application/json" -d @- http://localhost:8089/api/user/register
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/api/user/register",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Transactional
    public ResponseEntity<UserRegisterEntity> registerUser(@RequestBody UserRegisterEntity userEntity) {
        return ResponseEntity.ok(this.userRepository.save(userEntity));
    }

    // get list of registered users
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/api/users",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Transactional
    public ResponseEntity<List<UserRegisterEntity>> getGuests() {
        return ResponseEntity.ok(this.userRepository.findAll());
    }


}
