package ru.officelibrary.officelibrary.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.officelibrary.officelibrary.entity.Author;
import ru.officelibrary.officelibrary.repository.AdminAuthorRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Transactional
public class AdminAuthorService {
//    @Autowired
    private final AdminAuthorRepository adminAuthorRepository;

    public AdminAuthorService(AdminAuthorRepository adminAuthorRepository) {
        this.adminAuthorRepository = adminAuthorRepository;
    }

    public Author addAuthor(Author author){
        return adminAuthorRepository.save(author);
    }

    public void deleteAuthor(long id){
        adminAuthorRepository.delete(get(id));
    }

    public Author get(long id){
        return adminAuthorRepository.findById(id).get();
    }

    public List<Author> getAll(){
        return (List<Author>) adminAuthorRepository.findAll();
    }

    public Set<Author> findAuthorByIdList(String [] ids){
        return adminAuthorRepository.findAuthorByIdList(Stream.of(ids).map(Long::valueOf).collect(Collectors.toList()));
    }

}
