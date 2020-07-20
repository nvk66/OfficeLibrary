package ru.officelibrary.officelibrary.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.officelibrary.officelibrary.dto.request.UserDtoRequest;
import ru.officelibrary.officelibrary.entity.User;
import ru.officelibrary.officelibrary.repository.RoleRepository;
import ru.officelibrary.officelibrary.repository.UserRepository;

import java.util.Collections;
import java.util.List;

@Service
@Transactional
public class UserService {

//    @Autowired
    private final UserRepository userRepository;
//    @Autowired
    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
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

    private boolean isUserExists(String email){
        return userRepository.findUserByEmail(email) != null;
    }

    public User registerNewUserAccount(UserDtoRequest userDto) throws IllegalArgumentException{
        if (isUserExists(userDto.getEmail())){
            throw new IllegalArgumentException("There is an account with that email address:" + userDto.getEmail());
        }
        User user = new User();
        user.setName(userDto.getName());
        user.setLastName(userDto.getLastName());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        user.setRole(Collections.singletonList(roleRepository.findRoleByRoleName("User")));
        user.setPatronymicName(userDto.getPatronymicName());
        user.setBirthDate(userDto.getBirthDate());
        return userRepository.save(user);
    }
}
