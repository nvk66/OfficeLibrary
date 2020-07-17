package ru.officelibrary.officelibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

@Controller
public class GenreController {
    @Autowired
    private BookService bookService;
    @Autowired
    private GenreService genreService;
    @Autowired
    private GenreValidator genreValidator;

    @RequestMapping("/genre")
    public ModelAndView genreHome() {
        List<Genre> listGenre = genreService.getAll().stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        ModelAndView mav = new ModelAndView("genre");
        mav.addObject("listGenre", listGenre);
        return mav;
    }

    @GetMapping(value = "genre/new")
    public ModelAndView newGenreForm(ModelAndView model, BindingResult result) {
        Genre genre = new Genre();
        model.addObject("genres", genre);
        model.setViewName("genre_form");
        return model;
    }

    @GetMapping("genre/edit")
    public ModelAndView editGenreForm(@RequestParam long id) {
        ModelAndView mav = new ModelAndView("genre_form");
        Genre genre = genreService.getById(id);
        mav.addObject("genres", genre);
        return mav;
    }

    @PostMapping(value = "genre/save")
    public ModelAndView saveGenre(@Valid @ModelAttribute Genre genre, BindingResult result, ModelAndView model) {
        genreValidator.validate(genre, result);
        if (result.hasErrors()){
            model.addObject("genres", genre);
            model.addObject("error", "Data was not updated");
            model.setViewName("genre_form");
            return model;
        } else {
            try {
                if (genre.getGenreId() == 0) {
                    genreService.addGenre(genre);
                } else {
                    genreService.getById(genre.getGenreId());
                }
                genreService.addGenre(genre);
                return new ModelAndView("redirect:/genre");
            } catch (Exception e){
                model.addObject("genres", genre);
                model.addObject("error", e.getMessage());
                model.setViewName("genre_form");
                return model;
            }
        }
    }

    @RequestMapping("genre/delete")
    public String deleteGenreForm(@RequestParam long id) {
        genreService.deleteGenre(id);
        return "redirect:/genre";
    }
}
