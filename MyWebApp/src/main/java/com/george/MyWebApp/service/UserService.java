package com.george.MyWebApp.service;

import com.george.MyWebApp.UserNotFoundException;
import com.george.MyWebApp.model.User;
import com.george.MyWebApp.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> getAllUsers() {
        return (List<User>) repository.findAll();
    }

    public void save(User user) {
        repository.save(user);
    }

    public User getUser(Long id) throws UserNotFoundException {
        Optional<User> result = repository.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new UserNotFoundException("Could not find any user with id " + id);
    }

    public void deleteUser(Long id) throws UserNotFoundException {
        Long count = repository.countById(id);
        if (count == null || count == 0) {
            throw new UserNotFoundException("Could not find any user with id " + id);
        }
        repository.deleteById(id);
    }
}
