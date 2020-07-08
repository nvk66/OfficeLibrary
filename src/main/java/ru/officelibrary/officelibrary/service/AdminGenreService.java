package ru.officelibrary.officelibrary.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.officelibrary.officelibrary.model.Genre;
import ru.officelibrary.officelibrary.repository.AdminGenreRepository;

import java.util.List;

public class AdminGenreService {
    @Autowired
    private AdminGenreRepository adminGenreRepository;

    public AdminGenreService(AdminGenreRepository adminGenreRepository) {
        this.adminGenreRepository = adminGenreRepository;
    }

    public Genre addGenre(Genre genre){
        return adminGenreRepository.save(genre);
    }

    public void deleteAuthor(Genre genre){
        adminGenreRepository.delete(genre);
    }

    public Genre getById(long id){
        return adminGenreRepository.findById(id).get();
    }

    public List<Genre> getAll(){
        return (List<Genre>) adminGenreRepository.findAll();
    }
}
