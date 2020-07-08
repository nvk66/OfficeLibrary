package ru.officelibrary.officelibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.officelibrary.officelibrary.model.Author;
import ru.officelibrary.officelibrary.model.Book;
import ru.officelibrary.officelibrary.model.Genre;
import ru.officelibrary.officelibrary.model.User;
import ru.officelibrary.officelibrary.service.AdminAuthorService;
import ru.officelibrary.officelibrary.service.AdminBookService;
import ru.officelibrary.officelibrary.service.AdminGenreService;
import ru.officelibrary.officelibrary.service.AdminService;

import java.util.List;
import java.util.Map;

//@RestController
@Controller
public class MainController {

    //    private final AdminRepository adminRepository;
    @Autowired
    private AdminService adminService;
    private AdminBookService adminBookService;
    private AdminAuthorService adminAuthorService;
    private AdminGenreService adminGenreService;


    @RequestMapping("/")
    public String welcome(ModelMap model) {
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
    public String saveUser(@ModelAttribute("user") User user) {
        adminService.addUser(user);
        return "redirect:/";
    }

    @RequestMapping("/edit")
    public ModelAndView editUserForm(@RequestParam long id) {
        ModelAndView mav = new ModelAndView("edit_user");
        User user = adminService.getByID(id);
        mav.addObject("user", user);
        return mav;
    }

    @RequestMapping("/delete")
    public String deleteUserForm(@RequestParam long id) {
        adminService.deleteUser(id);
        return "redirect:/";
    }

    @RequestMapping(value = "book/new")
    public String newBookForm(Map<String, Object> model) {
        Book book = new Book();
        model.put("book", book);
        return "new_book";
    }

    @RequestMapping(value = "book/save", method = RequestMethod.POST)
    public String saveBook(@ModelAttribute("book") Book book) {
        adminBookService.addBook(book);
        return "redirect:/book";
    }

    @RequestMapping("book/edit")
    public ModelAndView editBookForm(@RequestParam long id) {
        ModelAndView mav = new ModelAndView("edit_book");
        Book book = adminBookService.get(id);
        mav.addObject("book", book);
        return mav;
    }

    @RequestMapping("/book")
    public ModelAndView bookHome() {
        List<Book> listBook = adminBookService.getAll();
        ModelAndView mav = new ModelAndView("book");
        mav.addObject("listBook", listBook);
        return mav;
    }

    @RequestMapping("book/delete")
    public String deleteDeleteForm(@RequestParam long id) {
        adminService.deleteUser(id);
        return "redirect:book";
    }

    @RequestMapping("/author")
    public ModelAndView authorHome() {
        List<Author> listAuthor = adminAuthorService.getAll();
        ModelAndView mav = new ModelAndView("author");
        mav.addObject("listAuthor", listAuthor);
        return mav;
    }

    @RequestMapping(value = "author/new")
    public String newAuthorForm(Map<String, Object> model) {
        Author author = new Author();
        model.put("author", author);
        return "new_author";
    }

    @RequestMapping(value = "author/save", method = RequestMethod.POST)
    public String saveAuthor(@ModelAttribute("author") Author author) {
        adminAuthorService.addAuthor(author);
        return "redirect:/author";
    }

    @RequestMapping("author/edit")
    public ModelAndView editAuthorForm(@RequestParam long id) {
        ModelAndView mav = new ModelAndView("edit_author");
        Author author = adminAuthorService.get(id);
        mav.addObject("author", author);
        return mav;
    }

    @RequestMapping("author/delete")
    public String deleteAuthorForm(@RequestParam long id) {
        adminService.deleteUser(id);
        return "redirect:author";
    }

    @RequestMapping("/genre")
    public ModelAndView genreHome() {
        List<Genre> listGenre = adminGenreService.getAll();
        ModelAndView mav = new ModelAndView("genre");
        mav.addObject("listGenre", listGenre);
        return mav;
    }

    @RequestMapping(value = "genre/new")
    public String newGenreForm(Map<String, Object> model) {
        Genre genre = new Genre();
        model.put("genres", genre);
        return "new_genre";
    }

    @RequestMapping(value = "genre/save", method = RequestMethod.POST)
    public String saveGenre(@ModelAttribute("genres") Genre genre) {
        adminGenreService.addGenre(genre);
        return "redirect:/genre";
    }

    @RequestMapping("genre/edit")
    public ModelAndView editGenreForm(@RequestParam long id) {
        ModelAndView mav = new ModelAndView("edit_genre");
        Genre genre = adminGenreService.getById(id);
        mav.addObject("genres", genre);
        return mav;
    }

//    @RequestMapping("/search")
//    public ModelAndView search(@RequestParam long bookId) {
//        List<User> result = adminService.search(bookId);
//        ModelAndView mav = new ModelAndView("search");
//        mav.addObject("result", result);
//        return mav;
//    }
}
