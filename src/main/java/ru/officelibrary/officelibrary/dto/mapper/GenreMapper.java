package ru.officelibrary.officelibrary.dto.mapper;

import org.mapstruct.Mapper;
import ru.officelibrary.officelibrary.dto.request.GenreDtoRequest;
import ru.officelibrary.officelibrary.dto.response.GenreDtoResponse;
import ru.officelibrary.officelibrary.model.Genre;

@Mapper
public interface GenreMapper {
    GenreDtoResponse genreToGenreDto(Genre genre);

    Genre genreDtoToGenre(GenreDtoRequest genre);
}
