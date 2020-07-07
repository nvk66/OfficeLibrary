package ru.officelibrary.officelibrary.dto.request;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookDtoRequest {
    private String bookName;
    private int publishingYear;
    private long genres;
    private long authorID;
}
