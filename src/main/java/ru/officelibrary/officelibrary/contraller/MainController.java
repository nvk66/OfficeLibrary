package ru.officelibrary.officelibrary.contraller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.officelibrary.officelibrary.dao.AdminRepository;
import ru.officelibrary.officelibrary.model.User;

@RestController
public class MainController {
    private final AdminRepository adminRepository;

    public MainController(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @RequestMapping("/save")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        return adminRepository.save(user).map(u -> new ResponseEntity<>(u, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
    }
}
