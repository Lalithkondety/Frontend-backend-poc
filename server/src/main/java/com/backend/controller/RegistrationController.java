package com.backend.controller;
import com.backend.model.User;
import com.backend.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegistrationController {
    @Autowired
    private RegistrationService service;

    @PostMapping("/registeruser")
    @CrossOrigin(origins = "*")
    public User registerUser(@RequestBody User user) throws Exception {
       String tempEmailId= user.getEmailId();
       if(tempEmailId != null && !"".equals(tempEmailId) ){
           User userObj = service.fetchUserByEmailId(tempEmailId);
           if (userObj != null){
               throw new Exception("user with this email already exit");
           }
       }
       User userObj = null;
       userObj = service.saveUser(user);
       return userObj;
    }

    @PostMapping("/login")
    @CrossOrigin(origins = "*")
    public User loginUser(@RequestBody User user) throws Exception {
        String tempEmailId= user.getEmailId();
        String tempPass = user.getPassword();
        User usrobj= null;
        if(tempEmailId != null && tempPass != null){
            usrobj = service.fetchUserByEmailIdAndPassword(tempEmailId,tempPass);
        }
        if(usrobj == null){
            throw new Exception("bad credentials");
        }
      return usrobj;
    }
}

