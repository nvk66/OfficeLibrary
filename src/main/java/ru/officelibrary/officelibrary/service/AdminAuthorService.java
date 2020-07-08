package ru.officelibrary.officelibrary.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.officelibrary.officelibrary.model.Author;
import ru.officelibrary.officelibrary.repository.AdminAuthorRepository;

import java.util.List;

public class AdminAuthorService {
    @Autowired
    AdminAuthorRepository adminAuthorRepository;

    public Author addAuthor(Author author){
        return adminAuthorRepository.save(author);
    }

    public void deleteAuthor(Author author){
        adminAuthorRepository.delete(author);
    }

    public Author get(long id){
        return adminAuthorRepository.findById(id).get();
    }

    public List<Author> getAll(){
        return (List<Author>) adminAuthorRepository.findAll();
    }

}
