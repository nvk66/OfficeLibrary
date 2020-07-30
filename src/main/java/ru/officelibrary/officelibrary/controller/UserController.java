package ru.officelibrary.officelibrary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.officelibrary.officelibrary.dto.UserDto;
import ru.officelibrary.officelibrary.entity.Role;
import ru.officelibrary.officelibrary.entity.User;
import ru.officelibrary.officelibrary.service.RoleService;
import ru.officelibrary.officelibrary.service.UserService;

import java.util.List;

@Controller
public class UserController {
    private final RoleService roleService;
    private final UserService userService;

    public UserController(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @RequestMapping("/user")
    public ModelAndView userHome() {
        List<User> listUser = userService.userList();
        ModelAndView mav = new ModelAndView("userPage");
        mav.addObject("listUser", listUser);
        return mav;
    }

    @GetMapping(value = "user/new")
    public ModelAndView newUserForm(ModelAndView model) {
        UserDto userDto = new UserDto();
        model.addObject("user", userDto);
        List<Role> roleList = roleService.roleList();
        model.addObject("roleList", roleList);
        model.setViewName("userFormPage");
        return model;
    }

    @GetMapping("user/edit/{id}/")
    public ModelAndView editUserForm(@PathVariable long id) {
        ModelAndView mav = new ModelAndView("userFormPage");
        User user = userService.getByID(id);
        UserDto userDto = new UserDto();
        userDto.setLastName(user.getLastName());
        userDto.setPatronymicName(user.getPatronymicName());
        userDto.setName(user.getName());
        userDto.setBirthDate(user.getBirthDate());
        userDto.setId(user.getId());
        userDto.setRoleIds((String[]) user.getRoles().stream().map(Role::getId).toArray());
        mav.addObject("user", userDto);
        return mav;
    }

    @PostMapping(value = "user/save")
    public ModelAndView saveUser(@ModelAttribute UserDto userDto) {
        User user = userService.createUser(userDto);
        userService.addUser(user);
        return userHome();
    }

    @RequestMapping("user/delete/{id}/")
    public ModelAndView deleteUserForm(@PathVariable long id) {
        userService.deleteUser(id);
        return userHome();
    }
}
