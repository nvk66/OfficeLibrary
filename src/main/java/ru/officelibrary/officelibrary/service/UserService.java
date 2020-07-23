package ru.officelibrary.officelibrary.service;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.officelibrary.officelibrary.dto.UserDto;
import ru.officelibrary.officelibrary.entity.User;
import ru.officelibrary.officelibrary.repository.RoleRepository;
import ru.officelibrary.officelibrary.repository.UserRepository;

import java.security.SecureRandom;
import java.util.Collections;
import java.util.List;

@Service
@Transactional
public class UserService {

//    @Autowired
    private final UserRepository userRepository;
//    @Autowired
    private final RoleRepository roleRepository;

    private final RoleService roleService;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10, new SecureRandom());

    public UserService(UserRepository userRepository, RoleRepository roleRepository, RoleService roleService) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.roleService = roleService;
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

    public User registerNewUserAccount(UserDto userDto) throws IllegalArgumentException{
        if (isUserExists(userDto.getEmail())){
            throw new IllegalArgumentException("There is an account with that email address:" + userDto.getEmail());
        }
        User user = new User();
        user.setName(userDto.getName());
        user.setLastName(userDto.getLastName());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setEmail(userDto.getEmail());
        user.setRole(Collections.singletonList(roleRepository.findRoleByRoleName("User")));
        user.setPatronymicName(userDto.getPatronymicName());
        user.setBirthDate(userDto.getBirthDate());
        return userRepository.save(user);
    }
}
