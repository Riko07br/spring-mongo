package com.springlearning.springmongo.services;

import com.springlearning.springmongo.domain.User;
import com.springlearning.springmongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;
    public List<User> findAll(){
        return repository.findAll();
    }
}
