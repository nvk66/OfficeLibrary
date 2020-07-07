package ru.officelibrary.officelibrary.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.officelibrary.officelibrary.model.Book;
import ru.officelibrary.officelibrary.repository.AdminBookRepository;

public class AdminBookService {

    @Autowired
    private static AdminBookRepository adminBookRepository;

    public AdminBookService(AdminBookRepository adminBookRepository) {
        AdminBookService.adminBookRepository = adminBookRepository;
    }

    public Book addBook(Book book){
        return adminBookRepository.save(book);
    }

    public void delete(Book book){
        adminBookRepository.delete(book);
    }
}
