package ru.officelibrary.officelibrary.service;


import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import ru.officelibrary.officelibrary.dao.AdminRepository;
import ru.officelibrary.officelibrary.model.User;

import java.util.Optional;

@Service
public class AdminService {

    private final Gson gson = new Gson();
    private static AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        AdminService.adminRepository = adminRepository;
    }

    public Optional<User> addUser(User user) {
//        AddUserDto addUserDto = gson.fromJson(jsonRequest, AddUserDto.class);
//        User user = new User();
//        user.setLastName(addUserDto.getLastName());
//        user.setName(addUserDto.getName());
//        user.setPatronymicName(addUserDto.getPatronymicName());
//        user.setBirthDate(addUserDto.getBirthDate());
//        user.setUserType(addUserDto.getUserType());
        return adminRepository.save(user);
    }

//    public void deleteUser(String jsonRequest) {
//        adminRepository.delete();
//    }
}
