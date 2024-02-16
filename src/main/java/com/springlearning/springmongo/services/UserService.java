package com.springlearning.springmongo.services;

import com.springlearning.springmongo.domain.User;
import com.springlearning.springmongo.dto.UserDTO;
import com.springlearning.springmongo.repositories.UserRepository;
import com.springlearning.springmongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public static User fromDto(UserDTO dto) {
        return new User(dto.getId(), dto.getName(), dto.getEmail());
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(String id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(id));
    }

    public User create(User obj) {
        return repository.insert(obj);
    }

    public User update(String id, User obj) {
        Optional<User> opObj = repository.findById(id);

        if (opObj.isEmpty())
            throw new ObjectNotFoundException(id);

        //update stuff-------------
        opObj.get().setName(obj.getName());
        opObj.get().setEmail(obj.getEmail());

        return repository.save(opObj.get());
    }

    public void delete(String id) {
        findById(id);
        repository.deleteById(id);
    }
}
