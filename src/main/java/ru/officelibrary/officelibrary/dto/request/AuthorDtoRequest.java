package ru.officelibrary.officelibrary.dto.request;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDtoRequest {
    private String name;
    private String lastName;
    private String patronymicName;
    private int birthYear;
    private String biography;
}
