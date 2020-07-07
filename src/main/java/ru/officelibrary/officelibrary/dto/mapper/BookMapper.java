package ru.officelibrary.officelibrary.dto.mapper;

import org.mapstruct.Mapper;
import ru.officelibrary.officelibrary.dto.request.BookDtoRequest;
import ru.officelibrary.officelibrary.dto.response.BookDtoResponse;
import ru.officelibrary.officelibrary.model.Book;

@Mapper
public interface BookMapper {
    BookDtoResponse bookToBookDto(Book book);

    Book bookDtoToBook(BookDtoRequest book);
}
