package ru.officelibrary.officelibrary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.officelibrary.officelibrary.entity.Genre;
import ru.officelibrary.officelibrary.repository.GenreRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Transactional
public class GenreService {
    @Autowired
    private GenreRepository genreRepository;

    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
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
        return genreRepository.save(genre);
    }

    public void deleteGenre(long id){
        genreRepository.delete(getById(id));
    }

    public Genre getById(long id){
        return genreRepository.findById(id).get();
    }

    public List<Genre> getAll(){
        return (List<Genre>) genreRepository.findAll();
    }

    public Set<Genre> findGenreByIdList(String [] ids){
        return genreRepository.findGenreByIdList(Stream.of(ids).map(Long::valueOf).collect(Collectors.toList()));
    }
}
