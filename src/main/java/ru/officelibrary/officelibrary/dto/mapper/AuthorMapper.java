package ru.officelibrary.officelibrary.dto.mapper;

import org.mapstruct.Mapper;
import ru.officelibrary.officelibrary.dto.request.AuthorDtoRequest;
import ru.officelibrary.officelibrary.dto.response.AuthorDtoResponse;
import ru.officelibrary.officelibrary.model.Author;

@Mapper
public interface AuthorMapper {
    AuthorDtoResponse authorToAuthorDto(Author author);

    Author authorDtoToAuthor(AuthorDtoRequest author);
}
