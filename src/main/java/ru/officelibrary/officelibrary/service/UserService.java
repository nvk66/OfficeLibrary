package ru.officelibrary.officelibrary.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.officelibrary.officelibrary.entity.User;
import ru.officelibrary.officelibrary.repository.UserRepository;

import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private static UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        UserService.userRepository = userRepository;
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

    public List<User> userList() {
        return (List<User>) userRepository.findAll();
    }

    public User getByID(long id){
        return userRepository.findById(id).get();
    }

    public User findUserByIdId(String ids){
        return userRepository.findUserById(ids);
    }
}
