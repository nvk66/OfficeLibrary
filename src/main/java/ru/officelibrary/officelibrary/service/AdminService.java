package ru.officelibrary.officelibrary.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.officelibrary.officelibrary.model.User;
import ru.officelibrary.officelibrary.repository.AdminRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AdminService {

    @Autowired
    private static AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        AdminService.adminRepository = adminRepository;
    }

//    private static AdminRepository adminRepository;

//    public AdminService(AdminRepository adminRepository) {
//        AdminService.adminRepository = adminRepository;
//    }

    public User addUser(User user) {
        return adminRepository.save(user);
    }

    public void deleteUser(long id) {
        adminRepository.deleteById(id);
    }

//    public User findUserByBookIDAndBusyStatus(long bookID){
//        return adminRepository.findUserByBookIDAndBusyStatusParams(bookID);
//    }

    public List<User> listAll() {
//        return (List<User>) adminRepository.findAll();
        var it = adminRepository.findAll();

        var users = new ArrayList<User>();
        it.forEach(users::add);

        return users;
    }

    public List<User> userList() {
        return (List<User>) adminRepository.findAll();
    }

//    public List<User> getAllUsers()
//    {
//        List<User> userList = adminRepository.findAll();
//
//        if(userList.size() > 0) {
//            return userList;
//        } else {
//            return new ArrayList<User>();
//        }
//    }

    public User getByID(long id){
        return adminRepository.findById(id).get();
    }
}
