package ru.officelibrary.officelibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

@Controller
public class GenreController {
    @Autowired
    private BookService bookService;
    @Autowired
    private GenreService genreService;
    @Autowired
    private GenreValidator genreValidator;

    @GetMapping("/genre")
    public ModelAndView genreHome() {
        List<Genre> listGenre = genreService.getAll().stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        ModelAndView mav = new ModelAndView("genrePage");
        mav.addObject("listGenre", listGenre);
        return mav;
    }

    @RequestMapping(value = "/genre/",  method={RequestMethod.POST, RequestMethod.GET})
    public ModelAndView newGenreForm(ModelAndView model, BindingResult result) {
        Genre genre = new Genre();
        model.addObject("genres", genre);
        model.setViewName("genreFormPage");
        return model;
    }

    @RequestMapping(value = "/genre/edit/{id}/", method={RequestMethod.PUT, RequestMethod.GET})
    public ModelAndView editGenreForm(@PathVariable long id) {
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
            model.addObject("error", "Data was not updated");
            model.setViewName("genreFormPage");
            return model;
        } else {
            try {
                if (genre.getId() == 0) {
                    genreService.addGenre(genre);
                } else {
                    genreService.getById(genre.getId());
                }
                genreService.addGenre(genre);
                return new ModelAndView("genrePage");
            } catch (Exception e) {
                model.addObject("genres", genre);
                model.addObject("error", e.getMessage());
                model.setViewName("genreFormPage");
                return model;
            }
        }
    }

//    @RequestMapping("genre/delete")
//    public String deleteGenreForm(@RequestParam long id) {
//        genreService.deleteGenre(id);
//        return "redirect:/genre";
//    }

    @RequestMapping(value = "genre/delete/{id}/", method={RequestMethod.DELETE, RequestMethod.GET})
    public String deleteGenreForm(@PathVariable("id") Long id) {
        genreService.deleteGenre(id);
        return "genrePage";
    }

    @RequestMapping("/genre/{id}")
    public String viewGenre(@PathVariable long id, Model model) {
        Genre genre = genreService.getById(id);
        model.addAttribute("genre", genre);
        model.addAttribute("book", bookService.findBookByGenre(genre));
        return "genreSelectedPage";
    }
}
