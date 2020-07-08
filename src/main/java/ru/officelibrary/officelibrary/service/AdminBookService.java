package ru.officelibrary.officelibrary.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.officelibrary.officelibrary.model.Book;
import ru.officelibrary.officelibrary.repository.AdminBookRepository;

import java.util.List;

public class AdminBookService {

    @Autowired
    private static AdminBookRepository adminBookRepository;

    public AdminBookService(AdminBookRepository adminBookRepository) {
        AdminBookService.adminBookRepository = adminBookRepository;
    }

    public Book addBook(Book book){
        return adminBookRepository.save(book);
    }

    public void deleteBook(Book book){
        adminBookRepository.delete(book);
    }

    public Book get(long id){
        return adminBookRepository.findById(id).get();
    }

    public List<Book> getAll(){
        return (List<Book>) adminBookRepository.findAll();
    }
}
