package ru.officelibrary.officelibrary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.officelibrary.officelibrary.entity.Book;
import ru.officelibrary.officelibrary.repository.AdminBookRepository;

import java.util.List;

@Service
@Transactional
public class AdminBookService {

    @Autowired
    private static AdminBookRepository adminBookRepository;

    @Autowired
    private static AdminAuthorService adminAuthorService;

    public AdminBookService(AdminBookRepository adminBookRepository) {
        AdminBookService.adminBookRepository = adminBookRepository;
    }

    public Book addBook(Book book){
        return adminBookRepository.save(book);
    }

    public void deleteBook(long id){
        adminBookRepository.delete(get(id));
    }

    public Book get(long id){
        return adminBookRepository.findById(id).get();
    }

    public List<Book> getAll(){
        return (List<Book>) adminBookRepository.findAll();
    }

//    public List<Book> search(Author author) {
//        return adminBookRepository.search(author);
//    }
    public List<Book> search(long id) {
        return adminBookRepository.search(adminAuthorService.get(id));
    }
}
