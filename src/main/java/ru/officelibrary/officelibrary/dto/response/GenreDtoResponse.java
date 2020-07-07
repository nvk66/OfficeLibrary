package ru.officelibrary.officelibrary.dto.response;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GenreDtoResponse {
    private long genreID;
    private String genreName;
}
