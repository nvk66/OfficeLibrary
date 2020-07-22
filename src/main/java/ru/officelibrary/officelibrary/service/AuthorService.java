package ru.officelibrary.officelibrary.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.officelibrary.officelibrary.entity.Author;
import ru.officelibrary.officelibrary.repository.AuthorRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Transactional
public class AuthorService {
//    @Autowired
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author addAuthor(Author author){
        return authorRepository.save(author);
    }

    public void deleteAuthor(long id){
        authorRepository.delete(get(id));
    }

    public Author get(long id){
        return authorRepository.findById(id).get();
    }

    public List<Author> getAll(){
        return (List<Author>) authorRepository.findAll();
    }

    public Set<Author> findAuthorByIdList(String [] ids){
        return authorRepository.findAuthorsByIdList(Stream.of(ids).map(Long::valueOf).collect(Collectors.toList()));
    }

}
