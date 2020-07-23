package ru.officelibrary.officelibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
        UserDto userDto = new UserDto();
        model.addObject("user", userDto);
        List<Role> roleList = roleService.roleList();
        model.addObject("roleList", roleList);
        model.setViewName("form_user");
        return model;
    }

    @GetMapping("user/edit")
    public ModelAndView editUserForm(@RequestParam long id) {
        ModelAndView mav = new ModelAndView("form_user");
        User user = userService.getByID(id);
        UserDto userDto = new UserDto();
        userDto.setLastName(user.getLastName());
        userDto.setPatronymicName(user.getPatronymicName());
        userDto.setName(user.getName());
        userDto.setBirthDate(user.getBirthDate());
        userDto.setUserId(user.getUserId());
        userDto.setRoleIds((String[]) user.getRoles().stream().map(Role::getRoleId).toArray());
        mav.addObject("user", userDto);
        return mav;
    }

    @PostMapping(value = "user/save")
    public ModelAndView saveUser(@ModelAttribute UserDto userDto) {
        User user = new User();
        user.setUserId(userDto.getUserId());
        user.setLastName(userDto.getLastName());
        user.setName(userDto.getName());
        user.setPatronymicName(userDto.getPatronymicName());
        user.setBirthDate(userDto.getBirthDate());
        user.setRole(roleService.findRoleByIdList(userDto.getRoleIds()));
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
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
