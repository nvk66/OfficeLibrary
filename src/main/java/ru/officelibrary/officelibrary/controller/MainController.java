package ru.officelibrary.officelibrary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.ModelAndView;
//import ru.officelibrary.officelibrary.dto.request.BookDtoRequest;
//import ru.officelibrary.officelibrary.dto.request.UserDtoRequest;
//import ru.officelibrary.officelibrary.entity.*;
//import ru.officelibrary.officelibrary.service.*;
//
//import java.util.List;
//import java.util.Map;
//
//@RestController
@Controller
public class MainController {
    //
//    //    private final AdminRepository adminRepository;
//    @Autowired
//    private UserService userService;
//    @Autowired
//    private BookService bookService;
//    @Autowired
//    private AdminAuthorService adminAuthorService;
//    @Autowired
//    private GenreService genreService;
//    @Autowired
//    private RoleService roleService;
//
//    @RequestMapping("/user")
//    public ModelAndView userHome(ModelMap model) {
////        List<User> userList = adminService.userList();
////        model.put("userList", userList);
////        return "user";
//        List<User> listUser = userService.userList();
//        ModelAndView mav = new ModelAndView("user");
//        mav.addObject("listUser", listUser);
//        return mav;
//    }
//
    @RequestMapping("/")
    public String welcome() {
//        model.put("message", "Welcome");
        return "index";
    }
}
//
//    @RequestMapping(value = "user/new")
//    public String newUserForm(Map<String, Object> model) {
////        User users = new User();
//        UserDtoRequest userDtoRequest= new UserDtoRequest();
//        model.put("user", userDtoRequest);
//        List<Role> roleList = roleService.roleList();
//        model.put("role", roleList);
//        return "new_user";
//    }
//
//    @RequestMapping(value = "user/new/save", method = RequestMethod.POST)
//    public String saveUser(@ModelAttribute("user") UserDtoRequest userDtoRequest) {
//        User user = new User();
//        user.setLastName(userDtoRequest.getLastName());
//        user.setName(userDtoRequest.getName());
//        user.setPatronymicName(userDtoRequest.getPatronymicName());
//        user.setBirthDate(userDtoRequest.getBirthDate());
//        user.setRole(roleService.findGenreByIdList(userDtoRequest.getRoleIds()));
//        userService.addUser(user);
//        return "redirect:/user";
//    }
//
//    @RequestMapping("user/edit")
//    public ModelAndView editUserForm(@RequestParam long id) {
//        ModelAndView mav = new ModelAndView("edit_user");
//        User user = userService.getByID(id);
//        mav.addObject("user", user);
//        return mav;
//    }
//
//    @RequestMapping("/delete")
//    public String deleteUserForm(@RequestParam long id) {
//        userService.deleteUser(id);
//        return "redirect:/user";
//    }
//
//    @RequestMapping(value = "book/new")
//    public String newBookForm(Map<String, Object> model) {
//        BookDtoRequest bookDtoRequest = new BookDtoRequest();
//        model.put("book", bookDtoRequest);
//        List<Genre> genreList = genreService.getAll();
//        List<Author> authorList = adminAuthorService.getAll();
//        model.put("genreList", genreList);
//        model.put("authorList", authorList);
//        return "new_book";
//    }
//
//    @RequestMapping("/book")
//    public ModelAndView bookHome() {
//        List<Book> listBook = bookService.getAll();
//        ModelAndView mav = new ModelAndView("book");
//        mav.addObject("listBook", listBook);
//        List<Author> authorList = adminAuthorService.getAll();
//        mav.addObject("author", authorList);
//        return mav;
//    }
//
//    @RequestMapping("/book/{id}")
//    public String viewBook(@PathVariable long id, Model model) {
//        model.addAttribute("book", bookService.get(id));
//        return "selected_book";
//    }
//
//    @RequestMapping("/author/{id}")
//    public String viewAuthor(@PathVariable long id, Model model) {
//        model.addAttribute("author", adminAuthorService.get(id));
////        model.addAttribute("book", adminBookService.search(id));
//        return "selected_author";
//    }
//
//    @RequestMapping("/genre/{id}")
//    public String viewGenre(@PathVariable long id, Model model) {
//        model.addAttribute("genre", genreService.getById(id));
////        model.addAttribute("book", adminBookService.search(id));
//        return "selected_genre";
//    }
//
//    @PostMapping(value = "book/new/save")
//    public String saveBook(@ModelAttribute("book") BookDtoRequest bookDtoRequest) {
//        Book book = new Book();
//        book.setBookName(bookDtoRequest.getBookName());
//        book.setAuthors(adminAuthorService.findAuthorByIdList(bookDtoRequest.getAuthorIds()));
//        book.setGenres(genreService.findGenreByIdList(bookDtoRequest.getGenreIds()));
//        book.setPublishingYear(bookDtoRequest.getPublishingYear());
//        bookService.addBook(book);
//        return "redirect:/book";
//    }
//
//    @RequestMapping("book/edit")
//    public ModelAndView editBookForm(@RequestParam long id) {
//        ModelAndView mav = new ModelAndView("edit_book");
//        Book book = bookService.get(id);
//        mav.addObject("book", book);
//        return mav;
//    }
//
//    @RequestMapping("book/delete")
//    public String deleteDeleteForm(@RequestParam long id) {
//        bookService.deleteBook(id);
//        return "redirect:book";
//    }
//
//    @RequestMapping("book/search")
//    public ModelAndView search(@RequestParam long id) {
//        List<Book> result = bookService.search(id);
//        ModelAndView mav = new ModelAndView("search");
//        mav.addObject("result", result);
//        return mav;
//    }
//
//    @RequestMapping("/author")
//    public ModelAndView authorHome() {
//        List<Author> listAuthor = adminAuthorService.getAll();
//        ModelAndView mav = new ModelAndView("author");
//        mav.addObject("listAuthor", listAuthor);
//        return mav;
//    }
//
//    @RequestMapping(value = "author/new")
//    public String newAuthorForm(Map<String, Object> model) {
//        Author author = new Author();
//        model.put("author", author);
//        return "new_author";
//    }
//
//    @RequestMapping(value = "author/save", method = RequestMethod.POST)
//    public String saveAuthor(@ModelAttribute("author") Author author) {
//        adminAuthorService.addAuthor(author);
//        return "redirect:/author";
//    }
//
//    @RequestMapping("author/edit")
//    public ModelAndView editAuthorForm(@RequestParam long id) {
//        ModelAndView mav = new ModelAndView("edit_author");
//        Author author = adminAuthorService.get(id);
//        mav.addObject("author", author);
//        return mav;
//    }
//
//    @RequestMapping("author/delete")
//    public String deleteAuthorForm(@RequestParam long id) {
//        adminAuthorService.deleteAuthor(id);
//        return "redirect:author";
//    }
//
////    @RequestMapping("/genre")
////    public ModelAndView genreHome() {
////        List<Genre> listGenre = adminGenreService.getAll();
////        ModelAndView mav = new ModelAndView("genre");
////        mav.addObject("listGenre", listGenre);
////        return mav;
////    }
////
//////    @RequestMapping(value = "genre/new")
//////    public String newGenreForm(Map<String, Object> model) {
//////        Genre genre = new Genre();
//////        model.put("genres", genre);
//////        return "new_genre";
//////    }
//////
//////    @RequestMapping(value = "genre/save", method = RequestMethod.POST)
//////    public String saveGenre(@ModelAttribute("genres") Genre genre) {
//////        adminGenreService.addGenre(genre);
//////        return "redirect:/genre";
//////    }
////
////    @GetMapping(value = "genre/new")
////    public ModelAndView newGenreForm(ModelAndView model) {
////        Genre genre = new Genre();
////        model.addObject("genres", genre);
////        model.setViewName("");
////    }
////
//////    @RequestMapping(value = "/newEmployee", method = RequestMethod.GET)
//////    public ModelAndView newContact(ModelAndView model) {
//////        Employee employee = new Employee();
//////        model.addObject("employee", employee);
//////        model.setViewName("EmployeeForm");
//////        return model;
//////    }
//////
//////    @RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
//////    public ModelAndView saveEmployee(@ModelAttribute Employee employee) {
//////        if (employee.getId() == 0) { // if employee id is 0 then creating the
//////            // employee other updating the employee
//////            employeeService.addEmployee(employee);
//////        } else {
//////            employeeService.updateEmployee(employee);
//////        }
//////        return new ModelAndView("redirect:/");
//////    }
//////    @RequestMapping(value = "/editEmployee", method = RequestMethod.GET)
//////    public ModelAndView editContact(HttpServletRequest request) {
//////        int employeeId = Integer.parseInt(request.getParameter("id"));
//////        Employee employee = employeeService.getEmployee(employeeId);
//////        ModelAndView model = new ModelAndView("EmployeeForm");
//////        model.addObject("employee", employee);
//////
//////        return model;
//////    }
////
////    @RequestMapping("genre/edit")
////    public ModelAndView editGenreForm(@RequestParam long id) {
////        ModelAndView mav = new ModelAndView("edit_genre");
////        Genre genre = adminGenreService.getById(id);
////        mav.addObject("genres", genre);
////        return mav;
////    }
////
////    @RequestMapping("genre/delete")
////    public String deleteGenreForm(@RequestParam long id) {
////        adminGenreService.deleteGenre(id);
////        return "redirect:/genre";
////    }
//
////    @RequestMapping(value = "book/reserve")
////    public String newReservationForm(Map<String, Object> model) {
////        History history = new History();
////        model.put("reserve", history);
////        return "new_genre";
////    }
////
////    @PostMapping(value = "genre/save")
////    public String saveReservation(@ModelAttribute("genres") Genre genre) {
////        adminGenreService.addGenre(genre);
////        return "redirect:/genre";
////    }
//
////    @RequestMapping("/search")
////    public ModelAndView search(@RequestParam long bookId) {
////        List<User> result = adminService.search(bookId);
////        ModelAndView mav = new ModelAndView("search");
////        mav.addObject("result", result);
////        return mav;
////    }
//}
