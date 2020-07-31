package ru.officelibrary.officelibrary.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.officelibrary.officelibrary.common.BookStatus;
import ru.officelibrary.officelibrary.dto.BookDto;
import ru.officelibrary.officelibrary.entity.Author;
import ru.officelibrary.officelibrary.entity.Book;
import ru.officelibrary.officelibrary.entity.Genre;
import ru.officelibrary.officelibrary.exception.ReservationException;
import ru.officelibrary.officelibrary.exception.SearchException;
import ru.officelibrary.officelibrary.repository.BookRepository;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final GenreService genreService;

    public BookService(BookRepository bookRepository, AuthorService authorService, GenreService genreService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.genreService = genreService;
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(long id) {
        bookRepository.delete(get(id));
    }

    public Book get(long id) {
        return bookRepository.findById(id).get();
    }

    public List<Book> getAll() {
        return (List<Book>) bookRepository.findAll();
    }

    public List<Book> search(long id) {
        Set<Author> authors = new HashSet<>();
        authors.add(authorService.get(id));
        return bookRepository.search(authors);
    }

    public Book findBookById(String ids) {
        return bookRepository.findBookById(ids);
    }


    public List<Book> findBookByAuthor(Author author) {
        HashSet<Author> authors = new HashSet<>();
        authors.add(author);
        return bookRepository.findBookByAuthorsIn(authors);
    }

    public List<Book> findBookByGenre(Genre genre) {
        return bookRepository.findBookByGenresIn(Collections.singleton(genre));
    }

    public boolean isItPossibleToBookABook(long id) throws ReservationException {
        if (get(id).getStats().equals(String.valueOf(BookStatus.FREE))) {
            return true;
        } else {
            throw new ReservationException(id, "Someone has already taken book ");
        }
    }

    public List<Book> findBookByNameEquals(String name) throws SearchException {
        if (bookRepository.findBookByNameEquals(name).isEmpty()) {
            throw new SearchException(name, "Unfortunately our library has no book with name ");
        } else {
            return bookRepository.findBookByNameEquals(name);
        }
    }

    public Book bookCreation(BookDto bookDto) {
        Book book = new Book();
        book.setName(bookDto.getName());
        book.setPublishingYear(bookDto.getPublishingYear());
        book.setGenres(genreService.findGenreByIdList(bookDto.getGenreIds()));
        book.setAuthors(authorService.findAuthorByIdList(bookDto.getAuthorIds()));
        book.setStats(String.valueOf(BookStatus.FREE));
        return book;
    }

}
