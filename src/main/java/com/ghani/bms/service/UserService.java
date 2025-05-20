package com.ghani.bms.service;

import com.ghani.bms.exception.UserNotFoundException;
import com.ghani.bms.model.User;
import com.ghani.bms.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    public User findUserById(long id){
        return userRepository.findById(id).orElseThrow(()->new UserNotFoundException("User not found for id :"+id));
    }

    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    public void deleteUserById(Long userId){
        userRepository.deleteById(userId);
    }
}
