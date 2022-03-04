package com.backend.service;
import com.backend.model.User;
import com.backend.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    @Autowired
    private RegistrationRepository repo;

    public User saveUser(User user){
         return repo.save(user);
    }

    public User fetchUserByEmailId(String emailId){
        return repo.findByEmailId(emailId);
    }
    public User fetchUserByEmailIdAndPassword(String emailId,String password){
        return repo.findByEmailIdAndPassword(emailId,password);
    }
}
