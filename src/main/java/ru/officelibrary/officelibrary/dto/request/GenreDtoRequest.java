package ru.officelibrary.officelibrary.dto.request;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GenreDtoRequest {
    private String genreName;
}
