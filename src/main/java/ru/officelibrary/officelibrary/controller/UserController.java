package ru.officelibrary.officelibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.officelibrary.officelibrary.dto.request.UserDtoRequest;
import ru.officelibrary.officelibrary.entity.Role;
import ru.officelibrary.officelibrary.entity.User;
import ru.officelibrary.officelibrary.service.RoleService;
import ru.officelibrary.officelibrary.service.UserService;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private RoleService roleService;
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
        UserDtoRequest userDtoRequest = new UserDtoRequest();
        model.addObject("user", userDtoRequest);
        List<Role> roleList = roleService.roleList();
        model.addObject("roleList", roleList);
        model.setViewName("UserForm");
        return model;
    }

    @GetMapping("user/edit")
    public ModelAndView editUserForm(@RequestParam long id) {
        ModelAndView mav = new ModelAndView("UserForm");
        User user = userService.getByID(id);
        UserDtoRequest userDtoRequest = new UserDtoRequest();
        userDtoRequest.setLastName(user.getLastName());
        userDtoRequest.setPatronymicName(user.getPatronymicName());
        userDtoRequest.setName(user.getName());
        userDtoRequest.setBirthDate(user.getBirthDate());
        userDtoRequest.setUserId(user.getUserId());
        userDtoRequest.setRoleIds((String[]) user.getRole().stream().map(Role::getRoleId).toArray());
        mav.addObject("user", userDtoRequest);
        return mav;
    }

    @PostMapping(value = "user/save")
    public ModelAndView saveUser(@ModelAttribute UserDtoRequest userDtoRequest) {
        User user = new User();
        user.setUserId(userDtoRequest.getUserId());
        user.setLastName(userDtoRequest.getLastName());
        user.setName(userDtoRequest.getName());
        user.setPatronymicName(userDtoRequest.getPatronymicName());
        user.setBirthDate(userDtoRequest.getBirthDate());
//        user.setRole(roleService.findRoleByIdList(userDtoRequest.getRoleIds()));
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
