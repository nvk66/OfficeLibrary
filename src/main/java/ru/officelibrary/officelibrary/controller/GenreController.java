package ru.officelibrary.officelibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.officelibrary.officelibrary.entity.Genre;
import ru.officelibrary.officelibrary.service.*;

import java.util.List;

@Controller
public class GenreController {

    @Autowired
    private BookService bookService;
    @Autowired
    private GenreService genreService;


    @RequestMapping("/genre")
    public ModelAndView genreHome() {
        List<Genre> listGenre = genreService.getAll();
        ModelAndView mav = new ModelAndView("genre");
        mav.addObject("listGenre", listGenre);
        return mav;
    }

    @GetMapping(value = "genre/new")
    public ModelAndView newGenreForm(ModelAndView model) {
        Genre genre = new Genre();
        model.addObject("genres", genre);
        model.setViewName("GenreForm");
        return model;
    }

    @GetMapping("genre/edit")
    public ModelAndView editGenreForm(@RequestParam long id) {
        ModelAndView mav = new ModelAndView("GenreForm");
        Genre genre = genreService.getById(id);
        mav.addObject("genres", genre);
        return mav;
    }

    @PostMapping(value = "genre/save")
    public ModelAndView saveGenre(@ModelAttribute Genre genre) {
        if (genre.getGenreId() == 0) {
            genreService.addGenre(genre);
        } else {
            genreService.getById(genre.getGenreId());
        }
        genreService.addGenre(genre);
        return new ModelAndView("redirect:/genre");
    }

    @RequestMapping("genre/delete")
    public String deleteGenreForm(@RequestParam long id) {
        genreService.deleteGenre(id);
        return "redirect:/genre";
    }
}
