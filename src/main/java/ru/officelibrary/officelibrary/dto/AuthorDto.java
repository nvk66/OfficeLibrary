package ru.officelibrary.officelibrary.dto;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDto {
    private String name;
    private String lastName;
    private String patronymicName;
    private int birthYear;
    private String biography;
}
