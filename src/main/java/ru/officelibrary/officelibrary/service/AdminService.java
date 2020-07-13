package ru.officelibrary.officelibrary.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.officelibrary.officelibrary.entity.User;
import ru.officelibrary.officelibrary.repository.AdminRepository;

import java.util.List;

@Service
@Transactional
public class AdminService {

    @Autowired
    private static AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        AdminService.adminRepository = adminRepository;
    }

    public User addUser(User user) {
        return adminRepository.save(user);
    }

    public void deleteUser(long id) {
        adminRepository.deleteById(id);
    }

    public List<User> userList() {
        return (List<User>) adminRepository.findAll();
    }

    public User getByID(long id){
        return adminRepository.findById(id).get();
    }
}
