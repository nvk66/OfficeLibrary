package ru.officelibrary.officelibrary.dto.response;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDtoResponse {
    private long authorID;
    private String name;
    private String lastName;
    private String patronymicName;
    private int birthYear;
    private String biography;

}
