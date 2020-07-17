package ru.officelibrary.officelibrary.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.officelibrary.officelibrary.entity.Author;
import ru.officelibrary.officelibrary.entity.Book;
import ru.officelibrary.officelibrary.repository.BookRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class BookService {

//    @Autowired
    private static BookRepository bookRepository;

//    @Autowired
    private static AuthorService authorService;

    public BookService(BookRepository bookRepository, AuthorService authorService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
    }

    public Book addBook(Book book){
        return bookRepository.save(book);
    }

    public void deleteBook(long id){
        bookRepository.delete(get(id));
    }

    public Book get(long id){
        return bookRepository.findById(id).get();
    }

    public List<Book> getAll(){
        return (List<Book>) bookRepository.findAll();
    }

//    public List<Book> search(Author author) {
//        return adminBookRepository.search(author);
//    }

    public List<Book> search(long id) {
//        Collections.singleton(adminAuthorService.get(id));
        Set<Author> authors = new HashSet<>();
        authors.add(authorService.get(id));
        return bookRepository.search(authors);
//        return adminBookRepository.search(Collections.singleton(adminAuthorService.get(id)));
//        return adminBookRepository.search(adminAuthorService.get(id));
    }

    public Book findBookById(String ids){
        return bookRepository.findBookById(ids);
    }
}
