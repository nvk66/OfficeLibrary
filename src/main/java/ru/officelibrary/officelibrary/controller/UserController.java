package ru.officelibrary.officelibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.officelibrary.officelibrary.entity.User;
import ru.officelibrary.officelibrary.service.BookService;
import ru.officelibrary.officelibrary.service.UserService;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private BookService bookService;
    @Autowired
    private UserService userService;


    @RequestMapping("/user")
    public ModelAndView userHome() {
        List<User> listUser = userService.userList();
        ModelAndView mav = new ModelAndView("user");
        mav.addObject("listUser", listUser);
        return mav;
    }

    @GetMapping(value = "user/new")
    public ModelAndView newUserForm(ModelAndView model) {
        User user = new User();
        model.addObject("user", user);
        model.setViewName("UserForm");
        return model;
    }

    @GetMapping("user/edit")
    public ModelAndView editUserForm(@RequestParam long id) {
        ModelAndView mav = new ModelAndView("UserForm");
        User user = userService.getByID(id);
        mav.addObject("user", user);
        return mav;
    }

    @PostMapping(value = "user/save")
    public ModelAndView saveUser(@ModelAttribute User user) {
        if (user.getUserId() == 0) {
            userService.addUser(user);
        } else {
            userService.getByID(user.getUserId());
        }
        userService.addUser(user);
        return new ModelAndView("redirect:/user");
    }

    @RequestMapping("user/delete")
    public String deleteUserForm(@RequestParam long id) {
        userService.deleteUser(id);
        return "redirect:/user";
    }
}
