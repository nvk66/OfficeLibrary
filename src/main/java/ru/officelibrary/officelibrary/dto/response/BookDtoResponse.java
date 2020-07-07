package ru.officelibrary.officelibrary.dto.response;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookDtoResponse {
    private long bookID;
    private String bookName;
    private int publishingYear;
    private long genres;
    private long authorID;
}
