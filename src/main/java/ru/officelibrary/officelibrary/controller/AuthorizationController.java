package ru.officelibrary.officelibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import ru.officelibrary.officelibrary.dto.request.UserDtoRequest;
import ru.officelibrary.officelibrary.entity.User;
import ru.officelibrary.officelibrary.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class AuthorizationController {
    @Autowired
    UserService userService;

    @GetMapping("/registration")
    public String showRegistrationForm(WebRequest request, Model model) {
        UserDtoRequest userDto = new UserDtoRequest();
        model.addAttribute("user", userDto);
        return "registration";
    }

    @PostMapping("/registration")
    public ModelAndView registerUserAccount
            (@ModelAttribute("user") @Valid UserDtoRequest userDto,
             HttpServletRequest request, Errors errors) {
        try {
            User registered = userService.registerNewUserAccount(userDto);
        } catch (Exception uaeEx) {
            return new ModelAndView().addObject("message",
                    "An account for that username/email already exists.");
        }
        return new ModelAndView("user", "user", userDto);
    }

//    @GetMapping("/login")
//    public String showLoginForm(WebRequest request, Model model){
//        return "login";
//    }

    @PostMapping("/")
    public String afterLogin(){
        return "index";
    }
}