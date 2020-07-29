package ru.officelibrary.officelibrary.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import ru.officelibrary.officelibrary.dto.UserDto;
import ru.officelibrary.officelibrary.entity.User;
import ru.officelibrary.officelibrary.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Log4j2
@Controller
public class AuthorizationController {
    private final UserService userService;

    public AuthorizationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String registration(WebRequest request, Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "registration";
    }

    @PostMapping("/registration")
    public ModelAndView registerUserAccount
            (@ModelAttribute("user") @Valid UserDto userDto,
             HttpServletRequest request, Errors errors) {
        try {
            User registered = userService.registerNewUserAccount(userDto);
        } catch (Exception uaeEx) {
            log.error("There was an exception in attempt to save user");
            return new ModelAndView().addObject("message",
                    "An account for that username/email already exists.");
        }
        return new ModelAndView("user", "user", userDto);
    }

    @PostMapping("/")
    public String afterLogin(){
        return "index";
    }
}
