package ru.officelibrary.officelibrary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.officelibrary.officelibrary.entity.Genre;
import ru.officelibrary.officelibrary.repository.AdminGenreRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Transactional
public class AdminGenreService {
    @Autowired
    private AdminGenreRepository adminGenreRepository;

    public AdminGenreService(AdminGenreRepository adminGenreRepository) {
        this.adminGenreRepository = adminGenreRepository;
    }

    public boolean isGenreAlreadyExists(String genre){
        for (Genre genre1 : getAll()){
            if (genre1.getGenreName().equals(genre)){
                return false;
            }
        }
        return true;
    }

    public Genre addGenre(Genre genre){
        return adminGenreRepository.save(genre);
    }

    public void deleteGenre(long id){
        adminGenreRepository.delete(getById(id));
    }

    public Genre getById(long id){
        return adminGenreRepository.findById(id).get();
    }

    public List<Genre> getAll(){
        return (List<Genre>) adminGenreRepository.findAll();
    }

    public Set<Genre> findGenreByIdList(String [] ids){
        return adminGenreRepository.findGenreByIdList(Stream.of(ids).map(Long::valueOf).collect(Collectors.toList()));
    }
}
