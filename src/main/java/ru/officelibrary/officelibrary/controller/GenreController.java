package ru.officelibrary.officelibrary.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.officelibrary.officelibrary.entity.Genre;
import ru.officelibrary.officelibrary.service.BookService;
import ru.officelibrary.officelibrary.service.GenreService;
import ru.officelibrary.officelibrary.validator.GenreValidator;

import javax.validation.Valid;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@Controller
public class GenreController {
    private final BookService bookService;
    private final GenreService genreService;
    private final GenreValidator genreValidator;

    public GenreController(BookService bookService, GenreService genreService, GenreValidator genreValidator) {
        this.bookService = bookService;
        this.genreService = genreService;
        this.genreValidator = genreValidator;
    }

    @GetMapping("/genre")
    public ModelAndView genreHome() {
        List<Genre> listGenre = genreService.getAll().stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        ModelAndView mav = new ModelAndView("genrePage");
        mav.addObject("listGenre", listGenre);
        return mav;
    }

    @RequestMapping(value = "/genre/", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView createNewGenre(ModelAndView model, BindingResult result) {
        Genre genre = new Genre();
        model.addObject("genre", genre);
        model.setViewName("genreFormPage");
        return model;
    }

    @RequestMapping(value = "/genre/edit/{id}/", method = {RequestMethod.PUT, RequestMethod.GET})
    public ModelAndView editGenre(@PathVariable long id) {
        ModelAndView mav = new ModelAndView("genreFormPage");
        Genre genre = genreService.getById(id);
        mav.addObject("genres", genre);
        return mav;
    }

    @PostMapping(value = "/genre/save/")
    public ModelAndView saveGenre(@Valid @ModelAttribute Genre genre, BindingResult result, ModelAndView model) {
        genreValidator.validate(genre, result);
        if (result.hasErrors()) {
            model.addObject("genres", genre);
            model.addObject("error", "Input error");
            model.setViewName("genreFormPage");
            return model;
        }
        try {
            genreService.addGenre(genre);
            return genreHome();
        } catch (Exception e) {
            log.error("There was an exception in attempt to save genre");
            model.addObject("genres", genre);
            model.addObject("error", e.getMessage());
            model.setViewName("genreFormPage");
            return model;
        }
    }

    @RequestMapping(value = "genre/delete/{id}/", method = {RequestMethod.DELETE, RequestMethod.GET})
    public ModelAndView deleteGenreForm(@PathVariable("id") Long id) {
        genreService.deleteGenre(id);
        return genreHome();
    }

    @RequestMapping("/genre/{id}")
    public String viewGenre(@PathVariable long id, Model model) {
        Genre genre = genreService.getById(id);
        model.addAttribute("genre", genre);
        model.addAttribute("book", bookService.findBookByGenre(genre));
        return "genreSelectedPage";
    }
}
