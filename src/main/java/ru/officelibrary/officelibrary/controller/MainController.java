package ru.officelibrary.officelibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.officelibrary.officelibrary.model.User;
import ru.officelibrary.officelibrary.service.AdminService;

import java.util.List;
import java.util.Map;

//@RestController
@Controller
public class MainController {

    //    private final AdminRepository adminRepository;
    @Autowired
    private AdminService adminService;

    // Обычно я использую интерфейс Model, но в целом разницы нет,
    // т.к. используется реализация LinkedHashMap(Key, Val)
    @RequestMapping("/")
    public String welcome(ModelMap model) {
//        model.put("message", this.message);
//        List<User> listUser = adminService.listAll();
        List<User> listUser = adminService.userList();
        model.put("list", listUser);
        return "index";
    }

    @RequestMapping(value = "/new")
    public String newUserForm(Map<String, Object> model) {
        User users = new User();
        model.put("user", users);
        return "new_user";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveCustomer(@ModelAttribute("user") User user) {
        adminService.addUser(user);
        return "redirect:/";
    }

    @RequestMapping("/edit")
    public ModelAndView editCustomerForm(@RequestParam long id) {
        ModelAndView mav = new ModelAndView("edit_user");
        User user = adminService.getByID(id);
        mav.addObject("user", user);
        return mav;
    }
}
