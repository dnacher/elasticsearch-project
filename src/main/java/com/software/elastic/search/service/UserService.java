package com.software.elastic.search.service;

import com.software.elastic.search.persistence.model.User;
import com.software.elastic.search.persistence.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;


/** Daniel Nacher 2024-02-10 */
@Service
public class UserService {

    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    public User saveUser(User user) throws Exception {
        if(user.getId()!= null) {
            throw new Exception("cannot save a user with a user.id");
        } else {
            user.setId(UUID.randomUUID().toString());
            return userRepository.save(user);
        }

    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    public Iterable<User> getUserByName(String name) {
        return userRepository.findByNameContains(name);
    }

    public Iterable<User> findByNameContainsOrUserNameContainsOrSurnameContains(String value) {
        return userRepository.findByvalue(value);
    }

}
