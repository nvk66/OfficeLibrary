package ru.officelibrary.officelibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.officelibrary.officelibrary.entity.Genre;
import ru.officelibrary.officelibrary.service.*;

import java.util.List;

@Controller
public class GenreController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private AdminBookService adminBookService;
    @Autowired
    private AdminAuthorService adminAuthorService;
    @Autowired
    private AdminGenreService adminGenreService;
    @Autowired
    private RoleService roleService;


    @RequestMapping("/genre")
    public ModelAndView genreHome() {
        List<Genre> listGenre = adminGenreService.getAll();
        ModelAndView mav = new ModelAndView("genre");
        mav.addObject("listGenre", listGenre);
        return mav;
    }

//    @RequestMapping(value = "genre/new")
//    public String newGenreForm(Map<String, Object> model) {
//        Genre genre = new Genre();
//        model.put("genres", genre);
//        return "new_genre";
//    }
//
//    @RequestMapping(value = "genre/save", method = RequestMethod.POST)
//    public String saveGenre(@ModelAttribute("genres") Genre genre) {
//        adminGenreService.addGenre(genre);
//        return "redirect:/genre";
//    }

    @GetMapping(value = "genre/new")
    public ModelAndView newGenreForm(ModelAndView model) {
        Genre genre = new Genre();
        model.addObject("genres", genre);
        model.setViewName("");
    }

//    @RequestMapping(value = "/newEmployee", method = RequestMethod.GET)
//    public ModelAndView newContact(ModelAndView model) {
//        Employee employee = new Employee();
//        model.addObject("employee", employee);
//        model.setViewName("EmployeeForm");
//        return model;
//    }
//
//    @RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
//    public ModelAndView saveEmployee(@ModelAttribute Employee employee) {
//        if (employee.getId() == 0) { // if employee id is 0 then creating the
//            // employee other updating the employee
//            employeeService.addEmployee(employee);
//        } else {
//            employeeService.updateEmployee(employee);
//        }
//        return new ModelAndView("redirect:/");
//    }
//    @RequestMapping(value = "/editEmployee", method = RequestMethod.GET)
//    public ModelAndView editContact(HttpServletRequest request) {
//        int employeeId = Integer.parseInt(request.getParameter("id"));
//        Employee employee = employeeService.getEmployee(employeeId);
//        ModelAndView model = new ModelAndView("EmployeeForm");
//        model.addObject("employee", employee);
//
//        return model;
//    }

    @RequestMapping("genre/edit")
    public ModelAndView editGenreForm(@RequestParam long id) {
        ModelAndView mav = new ModelAndView("edit_genre");
        Genre genre = adminGenreService.getById(id);
        mav.addObject("genres", genre);
        return mav;
    }

    @RequestMapping("genre/delete")
    public String deleteGenreForm(@RequestParam long id) {
        adminGenreService.deleteGenre(id);
        return "redirect:/genre";
    }
}
